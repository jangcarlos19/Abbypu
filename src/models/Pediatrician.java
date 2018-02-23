package models;

public class Pediatrician {
    private int id;
    private String name;
    private String lastname;
    private String phone;

    public Pediatrician() {
    }

    public Pediatrician(int id, String name, String lastname, int age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public Pediatrician setId(int id) {
        this.id = id;
        return this;
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

    public int getAge() {
        return phone;
    }

    public Pediatrician setAge(String phone) {
        this.phone = phone;
        return this;
    }
}
