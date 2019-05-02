package rpis71.doronina.oop.model;

public class Person {
    private String firstName;
    private String secondName;

    Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
}