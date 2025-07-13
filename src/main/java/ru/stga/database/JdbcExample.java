package ru.stga.database;

import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/Students"; //адрес бд для подключения
        String login = "login"; // логин для подключения к бд
        String password = "password"; // пароль для подключения к бд

        try (Connection connection = DriverManager.getConnection(jdbcUrl, login, password); // создаем соединение
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Students")) // получаем результат селекта
        {
            while (resultSet.next()) { // пока есть строки в таблице
                int id = resultSet.getInt("studentId"); // сохраняем айди записи в переменную
                String firstname = resultSet.getString("firstname"); // сохраняем имя записи из бд в переменную
                String lastname = resultSet.getString("lastname"); // сохраняем фамилию записи из бд в переменную
                int age = resultSet.getInt("age"); // сохраняем возраст
                System.out.println("ID: " + id + ", Name: " + firstname + " " + lastname + ", Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
