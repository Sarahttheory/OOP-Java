package rpis71.doronina.oop.model;

public class IndividualsTariff {
    private Service[] services;
    private int size; //ёмкость

    private int numbOfElements;
/*− по-умолчанию, инициирующий массив из 8 элементов (сами элементы имеют значение
null)*/
    IndividualsTariff(){
        this(8);
    }
    /*− принимающий целое число – емкость массива, инициирующий массив указанным числом
элементов (сами элементы имеют значение null)
*/
    IndividualsTariff(int size){
        this.services = new Service[size];
        for (int i = 0; i < size; i++){
            services[i] = null;
        }
        this.size = size;
    }
/*− принимающий массив услуг. В этом конструкторе происходит копирование элементов в
новый массив, и ссылка на него записывается в атрибут.
*/
    IndividualsTariff(Service[] services){
        /*Service[] copyArray = services.clone();
        services = copyArray;*/
        Service[] copyArray = new Service[services.length];
        for (int i = 0; i < services.length; i++){
            copyArray[i] = services[i];
        }
        services = copyArray;
    }
/*− добавляющий услугу в первое свободное место в массиве (принимает ссылку на экземпляр
класса Service). Пока этот метод возвращает истину после выполнения операции добавления
элемента*/
    public boolean add(Service service){
        if (this.numbOfElements >= this.size)
        {
            Service[] copyArray = new Service[this.size * 2];
            System.arraycopy(this.services, 0, copyArray, 0, this.size);
            this.services = copyArray;
        }
        this.services[numbOfElements] = service;
        numbOfElements++;
        return true;
    }
    /*− добавляющий услугу в заданное место в массиве (принимает номер и ссылку на экземпляр
класса Service). Пока этот метод возвращает истину после выполнения операции добавления
элемента*/
    public boolean add (){}
}