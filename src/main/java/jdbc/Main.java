package jdbc;

import java.sql.Driver;
import java.util.ServiceLoader;


public class Main {

	public static void main(String[] args) {
		ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
		for (Driver driver : loader) {
			System.out.println(driver);
		}
		
		Database db = new Database();
		db.setConnection("root", "123654");
		System.out.println("Success!");
	}

}
