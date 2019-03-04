package rpis71.doronina.oop.model;

public class Person {
    String firstName;
    String secondName;
/*− принимающий два параметра – имя, фамилия.*/
    Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }
/*− возвращающий имя*/
    public String getFirstName() {
        return firstName;
    }
/*− возвращающий фамилию*/
    public String getSecondName() {
        return secondName;
    }
    //жжьжьжьжьж
}