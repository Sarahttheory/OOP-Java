package rpis71.doronina.oop.model;

import java.util.Arrays;

//todo Везде должны быть ссылки типа Account, а не IndividualAccount
//todo все циклы до numbOfAccounts
public class AccountManager {

    private Account[] accounts; //todo массив типа Account[]
    private int numbOfAccounts;

    public AccountManager(int size){
        this.accounts = new Account[size];
        //this.numbOfAccounts = size;

    }

    public AccountManager(Account[] accounts){
        Account[] copyArray = new Account[numbOfAccounts];
        for (int i = 0; i < numbOfAccounts; i++){
            copyArray[i] = accounts[i];
        }
        this.accounts = copyArray;
    }

    public void accountExpansion(){
        Account[] copyArray = new Account[this.numbOfAccounts * 2];
        System.arraycopy(this.accounts, 0, copyArray, 0, this.numbOfAccounts);
        this.accounts = copyArray;
    }

    public boolean addAccount(Account account){
        if (this.numbOfAccounts == this.accounts.length) accountExpansion();
        this.accounts[numbOfAccounts] = account;
        numbOfAccounts++;
        return true;
    }

    public boolean addAccount(int index, Account account){
        if (this.numbOfAccounts == this.accounts.length) accountExpansion();
        System.arraycopy(this.accounts, index,accounts, index+1, numbOfAccounts - index + 1);
        this.accounts[index] = account;
        this.numbOfAccounts++;
        return true;
    }

    public Account getAccount(int index){
        return accounts[index];
    }

    public Account setAccount(int index, Account account){
        Account buffAccount = accounts[index];
        accounts[index] = account;
        return buffAccount;
    }

    public Account removeAccount(int index){
        Account buffAccount = accounts[index];
        for (int i = index; i < numbOfAccounts - 1; i++){
            accounts[i] = accounts[i+1];
        }
        accounts[numbOfAccounts - 1] = null;
        this.numbOfAccounts--;
        return buffAccount;
    }

    public int size(){
        return numbOfAccounts;
    }

    public Account[] getAccounts(){
        Account[] buffAccount = new Account[numbOfAccounts];
        System.arraycopy(accounts,0,buffAccount, 0, numbOfAccounts);
        return buffAccount;
    }

    public Tariff getTariff(long accountNumber){
        Tariff buffTariff = null;
        for (int i = 0; i < this.numbOfAccounts; i++) {
            if (accountNumber == accounts[i].getNumber()) {
                buffTariff = accounts[i].getTariff();
                break;
            }
        }
        return buffTariff;
    }

    public Tariff setTariff(long accountNumber, Tariff tariff){
        Tariff  buffTariff = null;
        for (int i = 0; i < numbOfAccounts; i++){
            if (accountNumber == accounts[i].getNumber()){
                buffTariff = accounts[i].getTariff();
                accounts[i].setTariff(tariff);
                break;
            }
        }
        return  buffTariff;
    }

    public Account[] getAccounts(String serviceName){
        Account[] accounts = new Account[numbOfAccounts];
        int sizeReturnedAccounts = 0;
        for (int i = 0; i < numbOfAccounts; i++){
            if (accounts[i].getTariff().containsService(serviceName)){
                accounts[sizeReturnedAccounts] = accounts[i];
                sizeReturnedAccounts++;
            }
        }
        Account[] returnedAccounts = new Account[sizeReturnedAccounts];
        System.arraycopy(accounts, 0, returnedAccounts, 0, sizeReturnedAccounts);
        return returnedAccounts;
    }

    public Account[] getAccounts(ServiceTypes type){
        Account[] accounts = new Account[numbOfAccounts];
        int sizeReturnedAccounts = 0;
        for (int i = 0; i < numbOfAccounts; i++){
            if (accounts[i].getTariff().containsService(type)){
                accounts[sizeReturnedAccounts] = accounts[i];
                sizeReturnedAccounts++;
            }
        }
        Account[] returnedAccounts = new Account[sizeReturnedAccounts];
        System.arraycopy(accounts, 0, returnedAccounts, 0, sizeReturnedAccounts);
        return returnedAccounts;
    }

    public Account[] getIndividualAccounts(){
        Account[] accounts = new Account[numbOfAccounts];
        int sizeReturnedAccounts = 0;
        for (int i = 0; i < numbOfAccounts; i++){
            if (accounts[i].getTariff() instanceof  IndividualsTariff){
                accounts[sizeReturnedAccounts] = accounts[i];
                sizeReturnedAccounts++;
            }
        }
        Account[] returnedAccounts = new Account[sizeReturnedAccounts];
        System.arraycopy(accounts, 0, returnedAccounts, 0, sizeReturnedAccounts);
        return returnedAccounts;
    }

    public Account[] getEntityAccounts(){
        Account[] accounts = new Account[numbOfAccounts];
        int sizeReturnedAccounts = 0;
        for (int i = 0; i < numbOfAccounts; i++){
            if (accounts[i].getTariff() instanceof  EntityTariff){
                accounts[sizeReturnedAccounts] = accounts[i];
                sizeReturnedAccounts++;
            }
        }
        Account[] returnedAccounts = new Account[sizeReturnedAccounts];
        System.arraycopy(accounts, 0, returnedAccounts, 0, sizeReturnedAccounts);
        return returnedAccounts;
    }
}