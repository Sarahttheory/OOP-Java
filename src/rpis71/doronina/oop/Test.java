package rpis71.doronina.oop;

import java.lang.*;
import rpis71.doronina.oop.model.*;


public class Test {
    public static void main (String[] args) {
        System.out.println("Я сделяль!");
        lab1tests();
    }

    public static void lab1tests(){
        /*IndividualsTariff firstTarrif = new IndividualsTariff();
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
        *//*        IndividualsTariff thirdTarrif = new IndividualsTariff(services);*/
    }

    public static void lab2tests(){
        /*Service service = new Service("интернет 20мб\\сек", 70);
        Service[] arrayService = {new Service(), new Service("интернет 2гб\\сек", 700), new Service("интернег 20кб\\сек", 6)};
        IndividualsTariff tariff = new IndividualsTariff();
        tariff.addService(service);
        System.out.println("Количество услуг: " + tariff.size());
        for (int i = 0; i < tariff.size(); i++){
            System.out.println(i+1 + "ая услуга: " + tariff.getService(i).getName() + " цена: " + tariff.getService(i).getCost());
        }

        EntityTariff entityTariff = new EntityTariff(arrayService);
        entityTariff.addService(new Service("интернет 2мб\\сек", 2));
        entityTariff.addService(0,new Service("интернет 20мб\\сек", 12));
        System.out.println("Количество услуг: " + entityTariff.size());
        for (int i = 0; i < entityTariff.size(); i++){
            System.out.println(i+1 + "ая услуга: " + entityTariff.getService(i).getName() + " цена: " + entityTariff.getService(i).getCost());
        }
        Person person = new Person("Гей", "Оргий");
        IndividualAccount account= new IndividualAccount(8453234, person);
        System.out.println(account.getNumber());
        account.setTariff(tariff);
        System.out.println(account.getTariff());
        System.out.println("Количество услуг: " + entityTariff.size());
        for (int i = 0; i < account.getTariff().size(); i++){
            System.out.println(i+1 + "ая услуга: " + account.getTariff().getService(i).getName() + " цена: " + account.getTariff().getService(i).getCost());
        }*/
    }

    public static void lab3tests(){
        /*Service service1 = new Service("интернет 20мб\\сек", 12, ServiceTypes.INTERNET);
        Service cloneService = service1.clone();
        System.out.println(cloneService.getName());
        System.out.println(cloneService.getCost());
        System.out.println(cloneService.getType());
        Service service2 = new Service("интернет 20мб\\сек", 70, ServiceTypes.INTERNET);
        Service service3 = new Service("интернет 2гб\\сек", 700, ServiceTypes.MAIL);
        Service service4 = new Service("интернег 20кб\\сек", 6, ServiceTypes.PHONE);
        Service[] services = {service1, service2, service3, service4};
        IndividualsTariff individualsTariff = new IndividualsTariff(services);
        Service[] internetServices = individualsTariff.getServices(ServiceTypes.INTERNET);
        for (int i = 0; i < internetServices.length; i++) {
            System.out.println(internetServices[i].getName() + " " + internetServices[i].getCost());
        }
        Person person = new Person("Иван", "Петров");
        IndividualAccount individualAccount = new IndividualAccount(976843, person, individualsTariff);
        EntityAccount entityAccount = new EntityAccount(34234324, "Peter", individualsTariff);
        Account[] accounts = {individualAccount, entityAccount};
        AccountManager accountManager = new AccountManager(accounts);
        System.out.println(accountManager.size());
        accountManager.removeAccount(1);
        System.out.println(accountManager.size());
        IndividualAccount individualAccount1 = new IndividualAccount(533424, new Person("Sergey", "Gay"), individualsTariff);
        accountManager.addAccount(1,individualAccount1);
        accountManager.addAccount(entityAccount);
        System.out.println(accountManager.size());*/
    }
    //todo где тесты для 2 и 3???
    public static void lab4tests(){
    }
}