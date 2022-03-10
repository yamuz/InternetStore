package dao;

import exceptions.DBConnectionException;
import utils.settings.PropertyReader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConnectorImpl implements Connector {
    private static Connection connection;

    public static Connection getConnection() throws DBConnectionException, IOException {
        if (connection != null)
            return connection;

        connection = connect(getConnectionParameters());
        return connection;
    }

    public void closeConnection() throws DBConnectionException {
        try {
            if (connection!=null)
                connection.close();
        } catch (SQLException e){
            throw new DBConnectionException(e.toString());
        }
    }

    private static Map<String, String> getConnectionParameters() throws IOException {
        Map<String, String> connectionParamsMap = new HashMap<>();
        Properties properties = PropertyReader.getSettings();

        String driverPath     = properties.getProperty("driverPath","com.mysql.cj.jdbc.Driver");
        String urlDB_prefix   = properties.getProperty("urlDB_prefix","jdbc:mysql");
        String connectionPort = properties.getProperty("connectionPort","3306");
        String db_name        = properties.getProperty("db_name","internet_Store");
        String urlDB          = urlDB_prefix + "://localhost:"+ connectionPort + "/" +
                                db_name +"?serverTimezone=UTC&useUnicode=true";
        String db_username    = properties.getProperty("db_username","admin");
        String db_password    = properties.getProperty("db_password","admin");

        connectionParamsMap.put("driverPath",driverPath);
        connectionParamsMap.put("urlDB", urlDB);
        connectionParamsMap.put("db_username", db_username);
        connectionParamsMap.put("db_password", db_password);
        return connectionParamsMap;
    }

    public static Connection connect(Map<String, String> connectionParams) throws DBConnectionException {
        try{
            Class.forName(connectionParams.get("driverPath"));
            connection = DriverManager.getConnection( connectionParams.get("urlDB"),
                    connectionParams.get("db_username"),
                    connectionParams.get("db_password"));
            return connection;
        } catch (Exception e){
            e.printStackTrace();
            throw new DBConnectionException(e.toString());
        }
    }
}
