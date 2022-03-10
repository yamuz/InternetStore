package repository;

import dao.ConnectorImpl;
import exceptions.DBConnectionException;
import model.Product;
import utils.settings.PropertyReader;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductRepository {
    private Connection connection;

    private ProductRepository() throws DBConnectionException, IOException {
        if (PropertyReader.isSQLDB())
            this.connection = ConnectorImpl.getConnection();
    }

    public static ProductRepository getNewInstance() throws DBConnectionException, IOException {
        return new ProductRepository();
    }

    private void fillArrayListDummy(ArrayList<Product> productList){
        productList.add(new Product(1L, "Asus X 51","description",
                new BigDecimal(4000_00),
                "img/img1.jpeg"));

        productList.add(new Product(2L,  "Dell 5353","description2",
                new BigDecimal(200_000),
                "img/img2.jpeg"));
    }

    public ArrayList<Product> getProductList() throws SQLException {
        ArrayList<Product> productList = new ArrayList<>();

        //map dummy data
        if (! PropertyReader.isSQLDB()) {
            fillArrayListDummy(productList);
            return productList;
        }

        //sql connection
        try (   PreparedStatement preparedStatement =
                        connection.prepareStatement("SELECT * FROM products");
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Product product = new Product( resultSet.getLong("id"),
                        resultSet.getString("productName"),
                        resultSet.getString("description"),
                        resultSet.getBigDecimal("price"),
                        resultSet.getString("imagePath"));
                productList.add(product);
            }
        }
        //connection.close();
        return productList;
    }
}
