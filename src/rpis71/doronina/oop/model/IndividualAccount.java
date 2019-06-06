package rpis71.doronina.oop.model;


public class IndividualAccount extends AbstractAccount{
    private Person person;

    public IndividualAccount(int number, Person person){
        this(number, person, new IndividualsTariff());
    }

    public IndividualAccount(int number, Person person, IndividualsTariff tariff){
        super(number,tariff);
        this.person = person;
    }

    public Person getPerson(){
        return this.person;
    }

    public void setPerson(Person person){
        this.person = person;
    }
}