package rpis71.doronina.oop.model;

public class IndividualsTariff {
    private Service[] services;
    private int size;

    IndividualsTariff(){
        this(8);
    }
    IndividualsTariff(int size){
        this.services = new Service[size];
        for (int i = 0; i < size; i++){
            services[i] = null;
        }
        this.size = size;
    }
    IndividualsTariff(Service[] services){
        System.arraycopy(services, 0, this.services, 0, this.size);
    }
    public void Add(){

    }
}