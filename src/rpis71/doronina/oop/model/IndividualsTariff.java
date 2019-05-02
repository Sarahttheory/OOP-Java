package rpis71.doronina.oop.model;

public class IndividualsTariff {
    private Service[] services;
    private int size; //ёмкость

    private int numbOfServices;


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
        /*Service[] copyArray = services.clone();
        services = copyArray;*/
        Service[] copyArray = new Service[services.length];
        for (int i = 0; i < services.length; i++){
            copyArray[i] = services[i];
        }
        this.services = copyArray;
    }


    public boolean add(Service service){
        if (this.numbOfServices >= this.size)
        {
            Service[] copyArray = new Service[this.size * 2];
            System.arraycopy(this.services, 0, copyArray, 0, this.size);
            this.services = copyArray;
        }
        this.services[numbOfServices] = service;
        numbOfServices++;
        return true;
    }

    public boolean addService(int index, Service service){
        this.services[index] = service;
        return true;
    }

    public Service getService(int index){
        return services[index];
    }

    public Service getService(String serviceName){
        int i;
        for (i = 0; i < serviceName.length(); i++){
            if(services[i].getName().equals(serviceName)) break;
        }
        return services[i];
    }

    public boolean hasService(String serviceName){
        boolean serviceIn = false;
        for (int i = 0; i < services.length; i++){
            if(services[i].getName().equals(serviceName)) {
                serviceIn = true;
                break;
            }
        }
        return serviceIn;
    }

    public Service setService(int index, Service service){
        Service buffService = services[index];
        services[index] = service;
        return buffService;
    }

    public Service removeService(int index){
        Service buffService = services[index];
        for (int i = index; i < services.length - 1; i++){
            services[i] = services[i+1];
        }
        services[services.length - 1] = null;
        this.numbOfServices--;
        return buffService;
    }

    public Service removeService(String serviceName){
        Service buffService = new Service();
        for (int i = 0; i < services.length; i++){
            if (services[i].getName().equals(serviceName)){
                buffService = services[i];
                for (int j = i; j < services.length - 1; j++){
                    services[j] = services[j+1];
                }
                services[services.length-1] = null;
                break;
            }
        }
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
        Service[] buffServices = new Service[numbOfServices];
        System.arraycopy(services,0,buffServices, 0, numbOfServices);
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
        return cost;
    }
}