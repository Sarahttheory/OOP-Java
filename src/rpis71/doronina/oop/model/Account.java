package rpis71.doronina.oop.model;

public class Account {
    int number;
    IndividualsTariff tariff;
    Person person;

    Account(int number, Person person){
        this.number = number;
        this.person = person;
        this.tariff = new IndividualsTariff();
        Service service = new Service();
        tariff.add(service);
    }
    Account(int number, Person person, IndividualsTariff tariff){
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