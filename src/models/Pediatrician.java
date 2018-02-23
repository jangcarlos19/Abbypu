package models;

public class Pediatrician {
    private int id;
    private String name;
    private String lastname;
    private int age;

    public Pediatrician() {
    }

    public Pediatrician(int id, String name, String lastname, int age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
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
        return age;
    }

    public Pediatrician setAge(int age) {
        this.age = age;
        return this;
    }
}
