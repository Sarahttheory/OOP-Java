package rpis71.doronina.oop.model;

public interface Tariff {
    boolean addService(Service service);

    boolean addService(int index, Service service);

    Service getService(int index);

    Service getService(String serviceName);

    boolean hasService(String serviceName);

    Service setService(int index, Service service);

    Service removeService(int index);

    Service removeService(String serviceName);

    int size();

    Service[] getServices();

    Service[] getServices(ServiceTypes type);

    Service[] sortedServicesByCost();

    double getCost();

    boolean containsService(ServiceTypes type);

    boolean containsService(String name);

    default void sortedServices(Service[] returnedServices){
        for (int i = returnedServices.length - 1; i > 0; i--)
            for (int j = 0; j < i; j++)
                if (returnedServices[j].getCost() > returnedServices[j+1].getCost()){
                    Service tempService = returnedServices[j];
                    returnedServices[j] = returnedServices[j+1];
                    returnedServices[j+1] = tempService;
                }
    }
}
