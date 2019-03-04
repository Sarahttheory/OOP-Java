package rpis71.doronina.oop.model;
/*
Создайте публичный класс Service – услуга, предоставляемая провайдером.
Класс характеризуется названием и стоимостью.
 */
public class Service {
    private String name;
    private int cost;

/*Конструктор − по-умолчанию, инициализирует название – строкой «интернет 100мб\сек», стоимость – 300*/
    Service(){
        this.name = "интернет 100мб\\сек";
        this.cost = 300;
    }
    /*- принимающий два параметра – название и стоимость.*/
    Service(String name, int cost){
        this.name = name;
        this.cost = cost;
    }
/*Метод − возвращающий название*/
    public String getName() {
        return name;
    }
   /*Метод − устанавливающий новое значение названия*/
    public void setName(String name) {
        this.name = name;
    }
    /*− возвращающий стоимость*/
    public int getCost() {
        return cost;
    }
    /*− устанавливающий новое значение стоимости*/
    public void setCost(int cost) {
        this.cost = cost;
    }
}