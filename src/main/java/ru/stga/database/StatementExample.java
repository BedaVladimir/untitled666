package ru.stga.database;

import java.sql.*;

public class StatementExample {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/Students"; //адрес бд для подключения
        String login = "login"; // логин для подключения к бд
        String password = "password"; // пароль для подключения к бд

        try (Connection connection = DriverManager.getConnection(jdbcUrl, login, password)) {
            Statement statement = connection.createStatement();

            int studentId = 600;
            String firstName = "Test";
            String lastName = "Test";
            int age = 18;
            double gpa = 5.0;

            String sql = "INSERT INTO students (studentid, firstname, lastname, age, gpa) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentId); //проверит, что на первое место ставится число, а не что-то другое
            preparedStatement.setString(2, firstName); //проверит, что на второе место будет строка
            preparedStatement.setString(3, lastName);
            preparedStatement.setInt(4, age);
            preparedStatement.setDouble(5, gpa);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
