package servlet;

import exceptions.DBConnectionException;
import model.Product;
import repository.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductServlet extends HttpServlet {
    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        try {
            this.productRepository = ProductRepository.getNewInstance();
            //System.out.println("this.productRepository: " + this.productRepository);
        } catch (DBConnectionException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String jspPage = "index";
        try {
            ArrayList<Product> productList = productRepository.getProductList();
            req.setAttribute("productList", productList);
        } catch (SQLException e) {
            System.out.println("ERROR..");
            e.printStackTrace();
        }
        req.getRequestDispatcher("/"+jspPage+".jsp").forward(req, resp);
    }
}
