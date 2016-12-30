package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.SQL;
import model.entities.Address;
import model.entities.User;

/**
 * Created by Виктор on 01.11.14.
 */
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("secondPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("login", FirstServlet.getLogin());
        try {
            req.setAttribute("isOpened", !FirstServlet.db.getConnection().isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }

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

        address_id = new Integer(req.getParameter("address_id"));
        if (address_id > 0) {
            List<User> users = new ArrayList<>();
            ResultSet rs1 = SQL.selectAllUsersAddress(address_id); // пользователи по адресу (address_is)
            try {
                while (rs1.next()) {
                    users.add(new User(rs1.getString(1), rs1.getString(2), rs1.getInt(3), rs1.getInt(4)));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("users", users);
        }
        req.getRequestDispatcher("secondPage.jsp").forward(req, resp);
    }
}
