package rpis71.doronina.oop.model;

public class EntityTariff implements Tariff {

    private Node<Service> head;
    private Node<Service> tail;
    private int size;

    public EntityTariff(){
        this.head = null;
        this.tail = null;
    }

    public EntityTariff(Service[] services){
        for (int i = 0; i < services.length; i++){
            addService(services[i]);
        }
    }

    public boolean addService(Service service){
        return addService(size, service);
    }

    public boolean addService(int index, Service service){
        Node<Service> node = new Node<>(null, null, service), currentNode, previousNode;
        if (tail == null) {
            head = tail = node;
        } else if (index == 0) {
            head.previous = node;
            node.next = head;
            head = node;
        } else if (index == size) {
            node.previous = tail;
            tail.next = node;
            tail = node;
        } else {
            currentNode = getNode(index);
            previousNode = currentNode.previous;
            previousNode.next = node;
            node.previous = previousNode;
            currentNode.previous = node;
            node.next = currentNode;
        }
        size++;
        return true;
    }

    public Service getService(int index){
        Node<Service> currentNode = getNode(index);
        return currentNode.value;
    }

    public Service getService(String serviceName){
        Node<Service> currentNode = searchNodeByName(serviceName);
        return null;
    }

    public boolean hasService(String serviceName){
        Node<Service> currentNode = searchNodeByName(serviceName);
        return false;
    }

    public Service setService(int index, Service service){
        Service replacedService = null;
        Node<Service> currentNode = getNode(index);
        replacedService = currentNode.value;
        currentNode.value = service;
        return replacedService;
    }

    public Service removeService(int index){
        Node<Service> nextNode;
        Service removedService = null;
        Node<Service> currentNode = getNode(index);

        removedService = currentNode.value;
        nextNode = currentNode.next;
        remove(removedService, currentNode,nextNode);
        return removedService;
    }

    public Service removeService(String serviceName){
        Node<Service> nextNode;
        Service removedService = null;
        Node<Service> currentNode = searchNodeByName(serviceName);
        removedService = currentNode.value;
        nextNode = currentNode.next;
        remove(removedService, currentNode, nextNode);
        this.size--;
        return removedService;
    }

    public int size(){
        return size;
    }

    public Service[] getServices(){
        Service[] returnedServices = new Service[size];
        Node<Service> currentNode = head;
        for (int i = 0; i < size; i++){
            returnedServices[i] = currentNode.value;
            currentNode = currentNode.next;
        }
        return returnedServices;
    }

    public Service[] getServices(ServiceTypes type){
        Service[] services = new Service[size];
        Node<Service> currentNode = head;
        int sizeReturnedServices = 0;
        for (int i = 0; i < size; i++){
            if (currentNode.value.getType() == type){
                services[i] = currentNode.value;
                sizeReturnedServices++;
            }
            currentNode = currentNode.next;
        }
        Service[] returnedServices = new Service[sizeReturnedServices];
        System.arraycopy(services, 0, returnedServices, 0, sizeReturnedServices);
        return returnedServices;
    }

    public Service[] sortedServicesByCost(){
        Service[] returnedServices = getServices();
        sortedServices(returnedServices);
        return returnedServices;
    }

    public double getCost(){
        Node<Service> currentNode = head;
        double cost = 0;
        while (currentNode.next != null){
            cost += currentNode.value.getCost();
            currentNode = currentNode.next;
        }
        return cost;
    }

    public boolean containsService(ServiceTypes type){
        //Service[] services = getServices(); //todo while-ом по нодам как в методе выше
        Node<Service> currentNode = head;
        while (currentNode.next != null){
            if(currentNode.value.getType() == type) return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    public boolean containsService(String name){
        Service[] services = getServices(); //todo while-ом по нодам как в методе выше
        Node<Service> currentNode = head;
        while (currentNode.next != null){
            if(currentNode.value.getName().equals(name)) return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    public Node<Service> getNode(int index){
        Node<Service> currentNode = head;
        int nodeNumber = 0;
        while (nodeNumber<index) {
            currentNode = currentNode.next;
            nodeNumber++;
        }
        return currentNode;
    }
    //todo аналогично getNode(index)
    public Node<Service> searchNodeByName(String serviceName){
        Node<Service> currentNode = head;
        while (currentNode.next !=null){
            if (currentNode.value.getName().equals(serviceName))
                break;
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public void remove(Service removedService, Node currentNode, Node nextNode){
        currentNode = currentNode.previous;
        currentNode.next = nextNode;
        nextNode.previous = currentNode;
        this.size--;
    }

    public class Node<E>{
        Node<E> next;
        Node<E> previous;
        E value;

        Node(Node<E> next, Node<E> previous, E e){
            this.next = next;
            this.previous = previous;
            this.value = e;
        }
        Node(){}
    }
}