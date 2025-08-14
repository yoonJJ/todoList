package com.example.todoList.repository;

import com.example.todoList.domain.Todo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoRepository {
    private final JdbcTemplate jdbcTemplate;

    public TodoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addTodo(Todo todo) {
        String sql = "INSERT INTO todo (content, completed) VALUES (?, ?)";
        jdbcTemplate.update(sql, todo.getContent(), todo.isCompleted());
    }

    public List<Todo> findAll() {
        String sql = "SELECT * FROM todo";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Todo(
                rs.getLong("id"),
                rs.getString("content"),
                rs.getBoolean("completed")
        ));
    }

    public void updateCompleted(Long id, boolean completed) {
        String sql = "UPDATE todo SET completed = ? WHERE id = ?";
        jdbcTemplate.update(sql, completed, id);
    }

    public void deleteTodo(Long id) {
        String sql = "DELETE FROM todo WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
