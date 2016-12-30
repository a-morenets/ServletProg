package servlets;

import jdbc.Database;
import jdbc.SQL;
import model.entities.Address;
import model.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Виктор on 01.11.14.
 */
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
    public static Database db = new Database();
    private static String login;
    private String password;
    private static List<User> users = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setLogin("root");
        setPassword("123654");

        db.setConnection(login, password);
        req.getRequestDispatcher("loginPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Address> addresses = new ArrayList<>();
        int address_id = -1;
        ResultSet rs = SQL.selectAllAddresses(); // все адреса
        try {
            rs.next();
            address_id = rs.getInt(1);
            rs.first();
            while (rs.next()) {
                addresses.add(new Address(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("addresses", addresses);
        req.setAttribute("address_id", address_id);

        req.getRequestDispatcher("./secondPage.jsp").forward(req, resp);
    }

    public static String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        FirstServlet.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static List<User> getUsers() {
        return users;
    }
}
