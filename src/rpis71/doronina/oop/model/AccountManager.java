package rpis71.doronina.oop.model;

//todo Везде должны быть ссылки типа Account, а не IndividualAccount
//todo все циклы до numbOfAccounts
public class AccountManager {

    private Account[] accounts; //todo массив типа Account[]
    private int numbOfAccounts;

    public AccountManager(int size){
        this.accounts = new Account[size];
        this.numbOfAccounts = size;
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
        if (indexOf(accountNumber) != -1){
            buffTariff = accounts[indexOf(accountNumber)].getTariff();
        }
        return buffTariff;
    }

    public Tariff setTariff(long accountNumber, Tariff tariff){
        Tariff buffTariff = null;
        if (indexOf(accountNumber) != -1){
            buffTariff = accounts[indexOf(accountNumber)].getTariff();
            accounts[indexOf(accountNumber)].setTariff(tariff);
        }
        return buffTariff;
    }

    public int indexOf(long accountNumber){
        int index = -1;
        for (int i = 0; i < this.numbOfAccounts; i++){
            if (accountNumber == accounts[i].getNumber()){
            index = i;
            }
        }
        return index;
    }
}