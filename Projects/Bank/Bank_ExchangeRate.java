package Bank;

import javax.persistence.*;

@Entity
@Table
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('UAH', 'USD', 'EUR')")
    Currency currencyOriginal;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('UAH', 'USD', 'EUR')")
    Currency currencyDestination;

    @Column
    double rate;

    public ExchangeRate() {
    }

    public ExchangeRate(Currency currencyOriginal, Currency currencyDestination, double rate) {
        this.currencyOriginal = currencyOriginal;
        this.currencyDestination = currencyDestination;
        this.rate = rate;
    }

    public Currency getCurrencyOriginal() {
        return currencyOriginal;
    }

    public void setCurrencyOriginal(Currency currencyOriginal) {
        this.currencyOriginal = currencyOriginal;
    }

    public Currency getCurrencyDestination() {
        return currencyDestination;
    }

    public void setCurrencyDestination(Currency currencyDestination) {
        this.currencyDestination = currencyDestination;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "id=" + id +
                ", currencyOriginal=" + currencyOriginal +
                ", currencyDestination=" + currencyDestination +
                ", rate=" + rate +
                '}';
    }
}
