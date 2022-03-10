package repository;

import dao.ConnectorImpl;
import exceptions.DBConnectionException;
import exceptions.UserRepositoryException;
import model.User;
import security.AuthenticationManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRepository {
    private Connection connection;

    private UserRepository() throws DBConnectionException, IOException {
        this.connection = ConnectorImpl.getConnection();
    }
    public static UserRepository getNewInstance() throws DBConnectionException, IOException {
        return new UserRepository();
    }

    public User getUserByEmail(String email) throws SQLException {
        User user = null;
        try (   PreparedStatement preparedStatement =
                        connection.prepareStatement("SELECT * FROM users WHERE email = ?");
        ) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User(resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name"),
                        resultSet.getString("role"),
                        resultSet.getString("phoneNumber"));
            }
        }
        connection.close();
        return user;
    }

    public boolean createUser(User user) throws UserRepositoryException, SQLException {
        int rows;
        try (   PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO users(email, password, fullname, role, phoneNumber ) " +
                                "VALUES (?,?,?,?,?)");
        ) {
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, AuthenticationManager.encode(user.getPassword()));
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.setString(5, user.getPhoneNumber());

            rows = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            connection.close();
            throw new UserRepositoryException(e.toString());
        }
        return rows > 0;
    }

    public ArrayList<User> getAllUsers()  {
        ArrayList<User> users = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT  * from users");
        }catch (Exception e){
            System.out.println(e.toString());
        }

        try {
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e){
            System.out.println(e.toString());
        }

        try{
            if (resultSet.next()) {
                User user = new User(resultSet.getLong("id"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getString("full_name"),
                    resultSet.getString("role"),
                    resultSet.getString("phoneNumber"));
                users.add(user);
            }
        } catch (Exception e){
            System.out.println(e.toString());
        }
        return users;
    }
}
