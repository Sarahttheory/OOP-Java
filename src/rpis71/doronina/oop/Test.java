package rpis71.doronina.oop;

import rpis71.doronina.oop.model.IndividualsTariff;
import rpis71.doronina.oop.model.Service;

public class Test {
    public static void main(String[] args) {
        System.out.println("Я сделяль!");
        lab1tests();
    }
    public static void lab1tests() {
        IndividualsTariff individualsTariff = new IndividualsTariff();
        Service service1 = new Service();
        individualsTariff.addService(service1);
        System.out.println(individualsTariff.size());
        System.out.println(individualsTariff.getService(1).getName() + " " + individualsTariff.getService(1).getCost());

        Service service2 = new Service("интернет 6мб\\сек", 60);
        Service service3 = new Service("интернет 7мб\\сек", 70);
        Service service4 = new Service("интернег 40кб\\сек", 7);
        IndividualsTariff individualsTariff1 = new IndividualsTariff(3);
        individualsTariff1.addService(service2);
        individualsTariff1.addService(service3);
        individualsTariff1.addService(service1);
        System.out.println("Количество услуг: " + individualsTariff1.size());
        for (int i = 0; i < individualsTariff1.size(); i++){
            System.out.println(i+1 + "ая услуга: " + individualsTariff1.getService(i).getName() + " цена: " + individualsTariff1.getService(i).getCost());
        }

        individualsTariff1.addService(2,service4);
        System.out.println("Количество услуг: " + individualsTariff1.size());
        for (int i = 0; i < individualsTariff1.size(); i++){
            System.out.println(i+1 + "ая услуга: " + individualsTariff1.getService(i).getName() + " цена: " + individualsTariff1.getService(i).getCost());
        }
    }
    //todo где тесты для 2 и 3???
}