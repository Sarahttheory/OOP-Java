package rpis71.doronina.oop.model;



public class IndividualsTariff implements Tariff {
    private Service[] services;
    private static final int DEFAULT_SIZE = 8;
    private int numbOfServices;

    public IndividualsTariff(){
        this(DEFAULT_SIZE);
    }

    public IndividualsTariff(int size){
        this.services = new Service[size];
        services[0] = new Service();
        this.numbOfServices = 1;
    }

    public IndividualsTariff(Service[] services){
        Service[] copyArray = new Service[services.length];
        System.arraycopy(services,0,copyArray,0,this.numbOfServices);
        this.services = copyArray;
    }


    public boolean addService(Service service){
        if (this.numbOfServices == this.services.length) tariffExpansion();
        this.services[numbOfServices] = service;
        numbOfServices++;
        return true;
    }

    public boolean addService(int index, Service service){
        if (this.numbOfServices == this.services.length) tariffExpansion();
        System.arraycopy(this.services, index,services, index+1, numbOfServices - index + 1);
        this.numbOfServices++;
        this.services[index] = service;
        return true;
    }

    public void tariffExpansion(){
        Service[] copyService = new Service[this.numbOfServices * 2];
        System.arraycopy(this.services, 0, copyService, 0, this.numbOfServices);
        this.services = copyService;
    }

    public Service getService(int index){
        return services[index];
    }

    public int indexOf(String serviceName){
        int index = -1;
        for (int i = 0; i < numbOfServices; i++){
            if(services[i].getName().equals(serviceName)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Service getService(String serviceName){
        Service getService = null;
        if (indexOf(serviceName) != -1) getService = services[indexOf(serviceName)];
        return getService;
    }

    public boolean hasService(String serviceName){
        return indexOf(serviceName) != -1;
    }

    public Service setService(int index, Service service){
        Service buffService = services[index];
        services[index] = service;
        return buffService;
    }

    public Service removeService(int index){
        Service buffService = services[index];
        for (int i = index; i < numbOfServices - 1; i++){
            services[i] = services[i+1];
        }
        services[services.length - 1] = null;
        this.numbOfServices--;
        return buffService;
    }

    public Service removeService(String serviceName){
        Service buffService = services[indexOf(serviceName)];
        for (int j = indexOf(serviceName); j < numbOfServices - 1; j++){
            services[j] = services[j+1];
        }
        services[services.length-1] = null;
        return buffService;
    }

    public int size(){
        return numbOfServices;
    }

    public Service[] getServices(){
        Service[] buffServices = new Service[numbOfServices];
        System.arraycopy(services,0,buffServices, 0, numbOfServices);
        return buffServices;
    }

    public Service[] sortedServicesByCost(){
        Service[] buffServices = getServices();
        for (int i = buffServices.length - 1; i > 0; i--)
            for (int j = 0; j < i; j++)
                if (buffServices[j].getCost() > buffServices[j+1].getCost()){
                    Service tempService = buffServices[j];
                    buffServices[j] = buffServices[j+1];
                    buffServices[j+1] = tempService;
                }
        return buffServices;
    }

    public double getCost(){
        double cost = 0;
        for (int i = 0; i < numbOfServices; i++){
            cost += (double)services[i].getCost();
        }
        cost += 50;
        return cost;
    }

    public Service[] getServices(ServiceTypes type){
        Service[] services = new Service[numbOfServices];
        int servicesSize = 0;
        for (int i = 0; i < numbOfServices; i++){
            if (this.services[i].getType() == type){
                services[servicesSize] = this.services[i];
                servicesSize++;
            }
        }
        Service[] returnedServices = new Service[servicesSize];
        System.arraycopy(services, 0, returnedServices,0, servicesSize);
        return returnedServices;
    }

    public boolean containsService(ServiceTypes type){
        for (int i = 0; i < this.numbOfServices; i++){
            if(services[i].getType() == type) return true;
        }

        return false;
    }

    public boolean containsService(String name){
        for (int i = 0; i < this.numbOfServices; i++){
            if(services[i].getName().equals(name)) return true;
        }

        return false;
    }
}