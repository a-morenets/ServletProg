package model.entities;

/**
 * Created by user on 18.11.2014.
 */
public class User {
    private String secondName;
    private String firstName;
    private int salary;
    private int user_address_id;

    public User() {
    }

    public User(String surName, String firstName, int salary, int user_address_id) {
        this.secondName = surName;
        this.firstName = firstName;
        this.salary = salary;
        this.user_address_id = user_address_id;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getSalary() {
        return salary;
    }

    public int getUser_address_id() {
        return user_address_id;
    }

    public static class Builder {
        User instance = new User();

        public Builder setFirstName(String firstName) {
            instance.firstName = firstName;
            return this;
        }
    }
}
