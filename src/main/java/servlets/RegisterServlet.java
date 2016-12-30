package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entities.User;

import java.io.IOException;
import java.util.Date;

/**
 * Created by user on 01.12.2014.
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int nextUserId = FirstServlet.db.getNextId("dbuser", "user_id");
        User user = new User(req.getParameter("surname"), req.getParameter("firstname"), 0, 0);
        Date createdDate = new Date();
        String SQL = "INSERT INTO dbuser(" +
                "user_id, " +
                "user_firstname, " +
                "user_created_date, " +
                "user_address_id, " +
                "user_birthdate, " +
                "user_secondname, " +
                "user_salary) " +
                "VALUES (" +
                nextUserId + ", '" +
                user.getFirstName() + "', '" +
                createdDate + "', " +
                "NULL, " +
                "NULL, '" +
                user.getSecondName() + "', " +
                user.getSalary() +
                ");";
        FirstServlet.db.runSQL(SQL);
    }
}
