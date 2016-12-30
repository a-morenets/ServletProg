package model.entities;

/**
 * Created by MORA on 20.11.2014.
 */
public class Address {
    private int address_id;
    private String city;
    private String street;
    private int building;

    public Address(int address_id, String city, String street, int building) {
        this.address_id = address_id;
        this.city = city;
        this.street = street;
        this.building = building;
    }

    public int getAddress_id() {
        return address_id;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getBuilding() {
        return building;
    }
}
