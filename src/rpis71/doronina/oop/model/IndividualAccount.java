package rpis71.doronina.oop.model;


public class IndividualAccount {
    private int number;
    private IndividualsTariff tariff;
    private Person person;

    IndividualAccount(int number, Person person){
        this(number, person, new IndividualsTariff());
    }
    IndividualAccount(int number, Person person, IndividualsTariff tariff){
        this.number = number;
        this.person = person;
        this.tariff = tariff;
    }

    public int getNumber(){
        return this.number;
    }

    public Person getPerson(){
        return this.person;
    }

    public void setPerson(Person person){
        this.person = person;
    }

    public IndividualsTariff getTariff(){
        return this.tariff;
    }

    public void setTariff(IndividualsTariff tariff){
        this.tariff = tariff;
    }
}