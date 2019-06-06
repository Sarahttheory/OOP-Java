package rpis71.doronina.oop.model;

public class Service {
    private String name;
    private int cost;
    private static final String DEFAULT_NAME = "интернет 100мб\\сек";
    private static final int DEFAULT_COST = 300;
    private  ServiceTypes type;
    private static final ServiceTypes DEFAULT_TYPE = ServiceTypes.INTERNET;

    public Service(){
        this(DEFAULT_NAME, DEFAULT_COST, DEFAULT_TYPE);
    }

    public Service(String name, int cost, ServiceTypes type){
        this.name = name;
        this.cost = cost;
        this.type = type;
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

    final public ServiceTypes getType(){return type;}
}