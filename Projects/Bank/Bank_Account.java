package Bank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false)
    private long accNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client owner;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('UAH', 'USD', 'EUR')")
    private Currency currency;

    @OneToMany(mappedBy = "debitAcc", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Transaction> debitTransactionList = new ArrayList<>();

    @OneToMany(mappedBy = "creditAcc", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Transaction> creditTransactionList = new ArrayList<>();

    public Account() {
    }

    public Account(long accNumber, Client owner, Currency currency) {
        this.accNumber = accNumber;
        this.owner = owner;
        this.currency = currency;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(long accNumber) {
        this.accNumber = accNumber;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency corrency) {
        this.currency = corrency;
    }

    public List<Transaction> getDebitTransactionList() {
        return Collections.unmodifiableList(debitTransactionList);
    }

    public void addDebitTransaction(Transaction transaction) {
        transaction.setDebitAcc(this);
        debitTransactionList.add(transaction);
    }

    public List<Transaction> getCreditTransactionList() {
        return Collections.unmodifiableList(creditTransactionList);
    }

    public void addCreditTransaction(Transaction transaction) {
        transaction.setCreditAcc(this);
        creditTransactionList.add(transaction);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accNumber=" + accNumber +
                ", owner=" + owner.getName() +
                ", currency=" + currency.name() +
                '}';
    }
}
