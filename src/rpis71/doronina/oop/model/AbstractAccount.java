package rpis71.doronina.oop.model;

public abstract class AbstractAccount implements Account {
    private Tariff tariff;
    private long number;

    protected AbstractAccount(long number, Tariff tariff) {
        this.number = number;
        this.tariff = tariff;
    }

    public long getNumber() {
        return this.number;
    }

    public Tariff getTariff() {
        return this.tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }
}
2
