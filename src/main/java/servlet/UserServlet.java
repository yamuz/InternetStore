package servlet;

import exceptions.DBConnectionException;
import model.User;
import repository.UserRepository;
import security.AuthenticationManager;
import utils.log.LogWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserServlet extends HttpServlet {
    UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        try {
            this.userRepository = UserRepository.getNewInstance();
        } catch (DBConnectionException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* String parameter = "not null";
        request.setAttribute("param", parameter);*/
        String[] path = request.getContextPath().split("/");
        String   action = path[path.length-1];
        if (action==null)
            return;
        ArrayList<User> users = new ArrayList<>();
        if ("all".equals(action)){
            users = userRepository.getAllUsers();
            request.setAttribute("users", users);
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        } else {
            String email = request.getParameter("email");

        }
        request.getRequestDispatcher("userServlet.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String passwordEntered = request.getParameter("password");
        if (email!=null && passwordEntered!=null)
            request.getRequestDispatcher("views/login.jsp").forward(request, response);

        User user = null;
        try {
            user = userRepository.getUserByEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
            LogWriter.writeToLogDB(e);
        }

        if (user!=null && AuthenticationManager.isAuthenticated(user.getPassword(), passwordEntered)) {
            response.sendRedirect("index.jsp");
            //TODO set cookie or user data
        } else {
            response.sendRedirect("views/login.jsp");
        }
    }
}
