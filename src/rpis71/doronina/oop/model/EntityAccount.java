package rpis71.doronina.oop.model;

public class EntityAccount extends AbstractAccount {
    private String name;

    public EntityAccount(long number, String name){
        this(number,name, new IndividualsTariff());
    }
    public EntityAccount(long number, String name, Tariff tariff){
        super(number,tariff);
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
}