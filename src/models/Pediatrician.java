package models;

public class Pediatrician {
    private int id;
    private String name;
    private String lastname;
    private String country;
    private int phone;
    private String email;

    public Pediatrician(String id, String name, String lastname, int score, Pediatrician byId) {
    }

    public Pediatrician(int id, String name, String lastname, String country, int phone, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.country = country;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public Pediatrician setId(int id) {
        this.id = id;
        return  this;
    }

    public String getName() {
        return name;
    }

    public Pediatrician setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public Pediatrician setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Pediatrician setCountry(String country) {
        this.country = country;
        return this;
    }

    public int getPhone() {
        return phone;
    }

    public Pediatrician setPhone(int phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Pediatrician setEmail(String email) {
        this.email = email;
        return this;
    }
}
