package rpis71.doronina.oop;

import rpis71.doronina.oop.model.IndividualsTariff;
import rpis71.doronina.oop.model.Service;
import rpis71.doronina.oop.model.Tariff;


public class Test {
    public static void main (String[] args) {
        System.out.println("Я сделяль!");
        lab1tests();
    }

    public static void lab1tests(){
        IndividualsTariff firstTarrif = new IndividualsTariff();
        Service service1 = new Service();
        firstTarrif.addService(service1);
        System.out.println(firstTarrif.getService(1).getName() + " " + firstTarrif.getService(1).getCost());

        Service service2 = new Service("интернет 20мб\\сек", 70);
        Service service3 = new Service("интернет 2гб\\сек", 700);
        Service service4 = new Service("интернег 20кб\\сек", 6);
        IndividualsTariff secondTarrif = new IndividualsTariff(3);
        secondTarrif.addService(service2);
        secondTarrif.addService(service3);
        secondTarrif.addService(service1);
        System.out.println("Количество услуг: " + secondTarrif.size());
        for (int i = 0; i < secondTarrif.size(); i++){
            System.out.println(i+1 + "ая услуга: " + secondTarrif.getService(i).getName() + " цена: " + secondTarrif.getService(i).getCost());
        }
//
        System.out.println("\nДобавление услуги по индексу");
        secondTarrif.addService(2,service4);
        System.out.println("Количество услуг: " + secondTarrif.size());
        for (int i = 0; i < secondTarrif.size(); i++){
            System.out.println(i+1 + "ая услуга: " + secondTarrif.getService(i).getName() + " цена: " + secondTarrif.getService(i).getCost());
        }

        System.out.println("Строимость тарифа: " + secondTarrif.getCost());
        Service[] services = new Service[7];
        /*        IndividualsTariff thirdTarrif = new IndividualsTariff(services);*/
    }

    public static void lab2tests(){
    }
    //todo где тесты для 2 и 3???
}