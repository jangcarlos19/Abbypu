package models;

public class Question {
    private String id;
    private String name;
    private String lastname;
    private int score;
    private Pediatrician pediatrician;

    public Question(){
    }

    public Question(String id, String name, String lastname, int score, Pediatrician pediatrician) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.score = score;
        this.pediatrician = pediatrician;
    }

    public String getId() {
        return id;
    }

    public Question setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Question setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public Question setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public int getScore() {
        return score;
    }

    public Question setScore(int score) {
        this.score = score;
        return this;
    }

    public Pediatrician getPediatrician() {
        return pediatrician;
    }

    public Question setPediatrician(Pediatrician pediatrician) {
        this.pediatrician = pediatrician;
        return this;
    }
}
