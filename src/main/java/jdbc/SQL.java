package jdbc;

import servlets.FirstServlet;

import java.sql.ResultSet;

/**
 * Created by user on 20.11.2014.
 */
public class SQL {
    static String SQL;

    // все адреса
    public static ResultSet selectAllAddresses() {
        SQL = "SELECT address_id, address_city, address_street, address_building FROM dbaddress " +
                "ORDER BY address_city, address_street, address_building";
        return FirstServlet.db.runSQL(SQL);
    }

    // юзеры по адресу address_id
    public static ResultSet selectAllUsersAddress(int address_id) {
        SQL = "SELECT user_secondname, user_firstname, user_salary, user_address_id FROM dbuser WHERE dbaddress_address_id = " + address_id +
                " ORDER BY user_salary";
        return FirstServlet.db.runSQL(SQL);
    }
}
