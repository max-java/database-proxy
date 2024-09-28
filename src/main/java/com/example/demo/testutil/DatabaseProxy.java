package com.example.demo.testutil;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseProxy {

    public static List<Entity> query(String q, JdbcTemplate jdbcTemplate) {
        return jdbcTemplate.query(q, new EntityMapper());
    }

    public static List<Entity> query(String q, DataSource dataSource) {
        return new JdbcTemplate(dataSource).query(q, new EntityMapper());
    }

    public static class EntityMapper implements RowMapper<Entity> {
        @Override
        public Entity mapRow(ResultSet rs, int rowNum) throws SQLException {
            Entity entity = new Entity();
            int columnCount = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                try {
                    entity.addData(new Entity.Data(rs.getMetaData().getColumnName(i), rs.getString(i)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return entity;
        }
    }

    public static class Entity {
        List<Data> data = new ArrayList<>();

        public Entity() {
        }

        public void addData(Data data) {
            this.data.add(data);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Data data : this.data) {
                sb.append(data.column).append(": ").append(data.value).append(" ");
            }
            return sb.toString();
        }

        public static class Data {
            String column;
            String value;

            public Data(String column, String value) {
                this.column = column;
                this.value = value;
            }
        }
    }
}
