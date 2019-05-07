package rpis71.doronina.oop.model;

//todo Аналогичные IndividualsTariff замечания. Смотреть этот класс буду только после того, как сделаешь тесты
public class AccountManager {
    private int size;
    private Account[] accounts;
    private int numbOfAccounts;

    AccountManager(int size){
        this.accounts = new Account[size];
        for (int i = 0; i < size; i++){
            accounts[i] = null;
        }
        this.size = size;
    }

    AccountManager(Account[] accounts){
        Account[] copyArray = new Account[accounts.length];
        for (int i = 0; i < accounts.length; i++){
            copyArray[i] = accounts[i];
        }
        this.accounts = copyArray;
    }

    public boolean addAccount(Account account){
        if (this.numbOfAccounts >= this.size)
        {
            Account[] copyArray = new Account[this.size * 2];
            System.arraycopy(this.accounts, 0, copyArray, 0, this.size);
            this.accounts = copyArray;
        }
        this.accounts[numbOfAccounts] = account;
        numbOfAccounts++;
        return true;
    }

    public boolean addAccount(int index, Account account){
        this.accounts[index] = account;
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
        for (int i = index; i < accounts.length - 1; i++){
            accounts[i] = accounts[i+1];
        }
        accounts[accounts.length - 1] = null;
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

    public IndividualsTariff getTariff(long accountNumber){
        IndividualsTariff buffTariff = new IndividualsTariff();
        for (int i = 0; i < this.accounts.length; i++){
            if (accountNumber == accounts[i].getNumber()){
                buffTariff = accounts[i].getTariff();
                break;
            }
        }
        return buffTariff;
    }

    public IndividualsTariff setTariff(long accountNumber, IndividualsTariff tariff){
        IndividualsTariff buffTariff = new IndividualsTariff();
        for (int i = 0; i < this.accounts.length; i++){
            if (accountNumber == accounts[i].getNumber()){
                buffTariff = accounts[i].getTariff();
                accounts[i].setTariff(tariff);
                break;
            }
        }
        return buffTariff;
    }
}