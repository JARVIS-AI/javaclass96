package Bank;

import javax.persistence.*;

@Entity
@Table
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "debit")
    private Account debitAcc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "credit")
    private Account creditAcc;

    @Column
    private long amount;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('UAH', 'USD', 'EUR')")
    private Currency currency;

    public Transaction() {
    }

    public Transaction(Account debitAcc, Account creditAcc, long amount, Currency currency) {
//        this.debitAcc = debitAcc;
        debitAcc.addDebitTransaction(this);
//        this.creditAcc = creditAcc;
        creditAcc.addCreditTransaction(this);
        this.amount = amount;
        this.currency = currency;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getDebitAcc() {
        return debitAcc;
    }

    public void setDebitAcc(Account debitAcc) {
        this.debitAcc = debitAcc;
    }

    public Account getCreditAcc() {
        return creditAcc;
    }

    public void setCreditAcc(Account creditAcc) {
        this.creditAcc = creditAcc;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", debitAcc=" + debitAcc.getAccNumber() +
                ", creditAcc=" + creditAcc.getAccNumber() +
                ", amount=" + amount +
                ", currency=" + currency +
                '}';
    }
}
