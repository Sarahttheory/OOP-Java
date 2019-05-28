package rpis71.doronina.oop.model;

//todo Аналогичные IndividualsTariff замечания. Смотреть этот класс буду только после того, как сделаешь тесты
public class AccountManager {

    private IndividualAccount[] accounts;
    private int numbOfAccounts;

    public AccountManager(int size){
        this.accounts = new IndividualAccount[size];
        this.numbOfAccounts = size;
    }

    public AccountManager(IndividualAccount[] accounts){
        IndividualAccount[] copyArray = new IndividualAccount[accounts.length];
        for (int i = 0; i < accounts.length; i++){
            copyArray[i] = accounts[i];
        }
        this.accounts = copyArray;
    }

    public void accountExpansion(){
        IndividualAccount[] copyArray = new IndividualAccount[this.numbOfAccounts * 2];
        System.arraycopy(this.accounts, 0, copyArray, 0, this.numbOfAccounts);
        this.accounts = copyArray;
    }

    public boolean addAccount(IndividualAccount account){
        if (this.numbOfAccounts == this.accounts.length) accountExpansion();
        this.accounts[numbOfAccounts] = account;
        numbOfAccounts++;
        return true;
    }

    public boolean addAccount(int index, IndividualAccount account){
        if (this.numbOfAccounts == this.accounts.length) accountExpansion();
        System.arraycopy(this.accounts, index,accounts, index+1, numbOfAccounts - index + 1);
        this.accounts[index] = account;
        this.numbOfAccounts++;
        return true;
    }

    public IndividualAccount getAccount(int index){
        return accounts[index];
    }

    public IndividualAccount setAccount(int index, IndividualAccount account){
        IndividualAccount buffAccount = accounts[index];
        accounts[index] = account;
        return buffAccount;
    }

    public IndividualAccount removeAccount(int index){
        IndividualAccount buffAccount = accounts[index];
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

    public IndividualAccount[] getAccounts(){
        IndividualAccount[] buffAccount = new IndividualAccount[numbOfAccounts];
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
        for (int i = 0; i < this.accounts.length; i++){
            if (accountNumber == accounts[i].getNumber()){
            index = i;
            }
        }
        return index;
    }
}