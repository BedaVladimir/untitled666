package ru.stga.database;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.List;

public class DbUtilsExample {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/Students"; //адрес бд для подключения
        String login = "login"; // логин для подключения к бд
        String password = "password"; // пароль для подключения к бд

        try (Connection connection = DriverManager.getConnection(jdbcUrl, login, password)) { // создаем соединение до БД
            QueryRunner queryRunner = new QueryRunner(); // квериРаннер это объект для чтения из БД
            BeanListHandler<Student> handler = new BeanListHandler<>(Student.class); // образует объект класса студент, где поля из бд == полям класса студент
            String query = "SELECT * FROM students WHERE age < ? AND gpa < ?";
            List<Student> students = queryRunner.query(connection, query, handler, 30, 5.0); // Создает java-объект из запроса
            students.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
