package Bank;

import org.hibernate.annotations.SourceType;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class AccountServiceImpl {

    public static void refill(EntityManager em, Scanner scanner) {
    
        System.out.println("Enter account number:");
        long account1 = Long.parseLong(scanner.nextLine());
        
        System.out.println("Enter amount:");
        long amount = Long.parseLong(scanner.nextLine());
        
        System.out.println("Enter currency:");
        String cur = scanner.nextLine();
        
        Currency currency = Currency.valueOf(cur);
        
        Query query = em.createQuery("SELECT a.accNumber FROM Account a WHERE (a.accNumber BETWEEN 1004000000L AND 1004999999L) AND a.currency = ?2", Long.class);
        
        query.setParameter(2, currency);
        long account2 = (long) query.getSingleResult();
        System.out.println(account2);
        Account[] accounts = checkCurrencyEquals(account1, account2, currency, em);
        if (accounts == null) {
            System.out.println("Transaction failed!");
        } else {
            createTransaction(em, accounts, amount, currency);

            Query query1 = em.createQuery("SELECT a FROM Account a WHERE a.accNumber = ?1", Account.class);
            query1.setParameter(1, account1);
            Account acc1 = new Account();
            acc1 = (Account) query1.getSingleResult();
            System.out.println(acc1.getDebitTransactionList());
            Query query2 = em.createQuery("SELECT a FROM Account a WHERE a.accNumber = ?1", Account.class);
            query2.setParameter(1, account2);
            Account acc2 = new Account();
            acc2 = (Account) query1.getSingleResult();
            System.out.println(acc2.getCreditTransactionList());
        }
        em.clear();
    }

    public static void transfer(EntityManager em, Scanner scanner) {
        System.out.println("Enter source account number:");
        long account2 = Long.parseLong(scanner.nextLine());
        System.out.println("Enter recipient account number:");
        long account1 = Long.parseLong(scanner.nextLine());
        System.out.println("Enter amount:");
        long amount = Long.parseLong(scanner.nextLine());
        System.out.println("Enter currency:");
        String cur = scanner.nextLine();
        Currency currency = Currency.valueOf(cur);
        Account[] accounts = checkCurrencyEquals(account1, account2, currency, em);
        if (accounts == null) {
            System.out.println("Currency warning!");
            accounts = checkClientsEquals(account1, account2, currency, em);
            if (accounts == null) {
                System.out.println("Transaction failed!");
            } else {
                createTransactionWithConversion(em, accounts, amount, currency);
            }
        } else {
            createTransaction(em, accounts, amount, currency);
        }

        Query query1 = em.createQuery("SELECT a FROM Account a WHERE a.accNumber = ?1", Account.class);
        query1.setParameter(1, account1);
        Account acc1 = new Account();
        acc1 = (Account) query1.getSingleResult();
        System.out.println(acc1.getDebitTransactionList());
        Query query2 = em.createQuery("SELECT a FROM Account a WHERE a.accNumber = ?1", Account.class);
        query2.setParameter(1, account2);
        Account acc2 = new Account();
        acc2 = (Account) query2.getSingleResult();
        System.out.println(acc2.getCreditTransactionList());

        em.clear();
    }

    public static void checkBalance(EntityManager em, Scanner sc) {
        System.out.println("Enter client ID:");
        long clientId = Long.parseLong(sc.nextLine());
        Client client = new Client();
        long sum = 0L;
        try {
            Query query = em.createQuery("SELECT c FROM Client c WHERE c.id = ?1", Client.class);
            query.setParameter(1, clientId);
            client = (Client) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Client not found!");
        }
        List<Account> accounts = client.getAccounts();
        for (Account acc : accounts) {
            List<Transaction> debit = acc.getDebitTransactionList();
            System.out.println(debit);
            for (Transaction t : debit) {
                if (t.getCurrency().equals(Currency.UAH)) {
                    sum += t.getAmount();
                } else {
                    try {
                        Query query = em.createQuery("SELECT r FROM ExchangeRate r WHERE r.currencyOriginal = ?1 AND r.currencyDestination= ?2", ExchangeRate.class);
                        query.setParameter(1, t.getCurrency());
                        query.setParameter(2, Currency.UAH);
                        ExchangeRate er = (ExchangeRate) query.getSingleResult();
                        sum += (long) (t.getAmount() * er.getRate());
                    } catch (NoResultException e) {
                        System.out.println("Exchange rate not found!");
                    }
                }
            }
            System.out.println("___");
            List<Transaction> credit = acc.getCreditTransactionList();
            System.out.println(credit);
            for (Transaction t : credit) {
                if (t.getCurrency().equals(Currency.UAH)) {
                    sum -= t.getAmount();
                } else {
                    try {
                        Query query = em.createQuery("SELECT r FROM ExchangeRate r WHERE r.currencyOriginal = ?1 AND r.currencyDestination= ?2", ExchangeRate.class);
                        query.setParameter(1, t.getCurrency());
                        query.setParameter(2, Currency.UAH);
                        ExchangeRate er = (ExchangeRate) query.getSingleResult();
                        sum -= (long) (t.getAmount() * er.getRate());
                    } catch (NoResultException e) {
                        System.out.println("Exchange rate not found!");
                    }
                }
            }
            System.out.println("*******************");
        }
        System.out.println(sum);
    }

    private static void createTransactionWithConversion(EntityManager em, Account[] accounts, long amount, Currency currency) {
        Account acc1 = accounts[0];
        System.out.println(acc1);
        Account acc2 = accounts[1];
        System.out.println(acc2);
        Account tAcc1 = new Account();
        Account tAcc2 = new Account();
        ExchangeRate rate = new ExchangeRate();
        try {
            Query query1 = em.createQuery("SELECT a FROM Account a WHERE (a.accNumber BETWEEN 3330000000L AND 3349999999L) AND a.currency = ?1", Account.class);
            query1.setParameter(1, acc1.getCurrency());
            tAcc1 = (Account) query1.getSingleResult();
            Query query2 = em.createQuery("SELECT a FROM Account a WHERE (a.accNumber BETWEEN 3330000000L AND 3349999999L) AND a.currency = ?1", Account.class);
            query2.setParameter(1, acc2.getCurrency());
            tAcc2 = (Account) query1.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Account not found!");
        }
        try {
            Query query = em.createQuery("SELECT r FROM ExchangeRate r WHERE r.currencyOriginal = ?1 AND r.currencyDestination = ?2", ExchangeRate.class);
            query.setParameter(1, acc2.getCurrency());
            query.setParameter(2, acc1.getCurrency());
            rate = (ExchangeRate) query.getSingleResult();
            System.out.println(rate);
        } catch (NoResultException e) {
            System.out.println("Exchange rate not found!");
        }
        long amount2 = (long) (amount * rate.getRate());
        em.getTransaction().begin();
        try {
            Transaction tr1 = new Transaction(acc1, tAcc1, amount2, acc1.getCurrency());
            Transaction tr2 = new Transaction(tAcc2, acc2, amount, currency);
            em.persist(tr1);
            em.persist(tr2);
            em.getTransaction().commit();
            System.out.println("Transaction commit!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Transaction rollback!");
        }

    }

    private static Account[] checkClientsEquals(long checkAcc1, long checkAcc2, Currency currency, EntityManager em) {
        Account acc1 = new Account();
        Account acc2 = new Account();
        try {
            Query query1 = em.createQuery("SELECT a FROM Account a WHERE a.accNumber = ?1", Account.class);
            query1.setParameter(1, checkAcc1);
            acc1 = (Account) query1.getSingleResult();
            Query query2 = em.createQuery("SELECT a FROM Account a WHERE a.accNumber = ?1", Account.class);
            query2.setParameter(1, checkAcc2);
            acc2 = (Account) query2.getSingleResult();

        } catch (NoResultException e) {
            System.out.println("Account not found!");
        }
        if (acc1.getOwner().equals(acc2.getOwner()) && acc2.getCurrency().equals(currency)) {
            Account[] accounts = {acc1, acc2};
            return accounts;
        } else {
            System.out.println("Clients not equals!");
            return null;
        }
    }


    private static void createTransaction(EntityManager em, Account[] accounts, long amount, Currency currency) {
        em.getTransaction().begin();
        try {
            Account acc1 = accounts[0];
            System.out.println(acc1);
            Account acc2 = accounts[1];
            System.out.println(acc2);
            Transaction tr = new Transaction(acc1, acc2, amount, currency);
            em.persist(tr);
            em.getTransaction().commit();
            System.out.println("Transaction commit!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Transaction rollback!");
        }
    }

    private static Account[] checkCurrencyEquals(long checkAcc1, long checkAcc2, Currency currency, EntityManager em) {
        Account acc1 = new Account();
        Account acc2 = new Account();
        try {
            Query query1 = em.createQuery("SELECT a FROM Account a WHERE a.accNumber = ?1", Account.class);
            query1.setParameter(1, checkAcc1);
            acc1 = (Account) query1.getSingleResult();
            Query query2 = em.createQuery("SELECT a FROM Account a WHERE a.accNumber = ?1", Account.class);
            query2.setParameter(1, checkAcc2);
            acc2 = (Account) query2.getSingleResult();

        } catch (NoResultException e) {
            System.out.println("Account not found!");
        }
        if (acc1.getCurrency().equals(acc2.getCurrency()) && acc1.getCurrency().equals(currency)) {
            Account[] accounts = {acc1, acc2};
            return accounts;
        } else {
            System.out.println("Currency not equals!");
            return null;
        }
    }
}