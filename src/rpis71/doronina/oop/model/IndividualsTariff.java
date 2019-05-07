package rpis71.doronina.oop.model;


//todo Все циклы, когда ты пробегаешься по Сервисам, должны быть до numbOfServices, ибо все твои элементы имеют номера [0, numbOfServices)
public class IndividualsTariff {
    private Service[] services;
    private int size; //ёмкость //todo а нафига? когда services.length и есть емкость?

    private int numbOfServices;

    //todo конструкторы public. Пункт 2 требований к выполнения заданий не выполнен
    IndividualsTariff(){
        this(8);
    }

    IndividualsTariff(int size){
        this.services = new Service[size];
        for (int i = 0; i < size; i++){ //todo этот цикл лишний, так как при создании массива все элементы имеют значения по-умолчанию. Для ссылок - это null
            services[i] = null;
        }
        this.size = size;
    }

    IndividualsTariff(Service[] services){
        /*Service[] copyArray = services.clone();
        services = copyArray;*/
        //todo зачем переменная, когда можно сразу работать с атрибутом? this.services = new Service[services.length]; ...
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
        //todo этот метод должен вставлять, а не заменять. То есть надо сначала сдвинуть элементы с index в право на 1
        this.services[index] = service;
        return true;
    }

    public Service getService(int index){
        return services[index];
    }


    /*todo в методах getService(String serviceName), hasService(String serviceName), removeService(String serviceName) -
      дублирование кода по поиску элемента с заданным именем.
      Вынеси это дублирование в отдельный метод, аля indexOf(String serviceName), который возвращает номер элемента или -1, если сервиса с таким именем нет
      И используй этот метод.
    */
    public Service getService(String serviceName){
        int i;
        //todo нужно явно проверять был ли найден элемент или нет. И если не найден, пока возвращать null
        for (i = 0; i < serviceName.length(); i++){
            if(services[i].getName().equals(serviceName)) break;
        }
        return services[i];
    }

    public boolean hasService(String serviceName){
        boolean serviceIn = false; //todo ну почему бы имя этой переменной и имя метода не сделать одинаковыми (так как метод возвращает значение переменной)?
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
        //todo зачем дублируешь код метода getServices()?
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
        double cost = 0; //todo забыла сервисный сбор 50 у.е.
        for (int i = 0; i < numbOfServices; i++){
            cost += (double)services[i].getCost();
        }
        return cost;
    }
}