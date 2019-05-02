package rpis71.doronina.oop.model;

public class Service {
    private String name;
    private int cost;


    Service(){
        this.name = "интернет 100мб\\сек";
        this.cost = 300;
    }

    Service(String name, int cost){
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}