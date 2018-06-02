//AMIR MOHAMMAD SAFARI LIVARI
//Author : AMS-H4CK3R
//Developer : JARVIS-AI


package Bank;

import javax.persistence.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Bank");
        EntityManager em = emf.createEntityManager();
        Scanner sc = new Scanner(System.in);

        try {
//            em.getTransaction().begin();
//            try {
//                ExchangeRate rate = new ExchangeRate(Currency.USD, Currency.UAH, 26.637804);
//                em.persist(rate);
//                em.getTransaction().commit();
//            } catch (Exception e) {
//                em.getTransaction().rollback();
//            }
//            em.clear();
//            em.getTransaction().begin();
//            try {
//                ExchangeRate rate = new ExchangeRate(Currency.UAH, Currency.USD, 0.037540);
//                em.persist(rate);
//                em.getTransaction().commit();
//            } catch (Exception e) {
//                em.getTransaction().rollback();
//            }
//            em.clear();
//            em.getTransaction().begin();
//            try {
//                ExchangeRate rate = new ExchangeRate(Currency.UAH, Currency.EUR, 0.033233);
//                em.persist(rate);
//                em.getTransaction().commit();
//            } catch (Exception e) {
//                em.getTransaction().rollback();
//            }
//            em.clear();
//            em.getTransaction().begin();
//            try {
//                ExchangeRate rate = new ExchangeRate(Currency.EUR, Currency.UAH, 30.090063);
//                em.persist(rate);
//                em.getTransaction().commit();
//            } catch (Exception e) {
//                em.getTransaction().rollback();
//            }
//            em.clear();
//            em.getTransaction().begin();
//            try {
//                ExchangeRate rate = new ExchangeRate(Currency.USD, Currency.EUR, 0.885269);
//                em.persist(rate);
//                em.getTransaction().commit();
//            } catch (Exception e) {
//                em.getTransaction().rollback();
//            }
//            em.clear();
//            em.getTransaction().begin();
//            try {
//                ExchangeRate rate = new ExchangeRate(Currency.EUR, Currency.USD, 1.129599);
//                em.persist(rate);
//                em.getTransaction().commit();
//            } catch (Exception e) {
//                em.getTransaction().rollback();
//            }
//            em.clear();

//            em.getTransaction().begin();
//            try {
//                Client client = new Client();
//                client = em.find(Client.class, 1L);
//                Account acc = new Account(26209780013L, client, Currency.EUR);
//                client.addAccount(acc);
//                em.persist(client);
//                em.getTransaction().commit();
//                System.out.println(acc.getOwner());
//            } catch (Exception e) {
//                em.getTransaction().rollback();
//            }
//
//            em.clear();
            while (true) {
                System.out.println("Chose action:");
                System.out.println("1 - Refill;");
                System.out.println("2 - Transfer;");
                System.out.println("3 - Balance check (UAH);");
                String param = sc.nextLine();
                switch (param) {
                    case "1":
                        AccountServiceImpl.refill(em, sc);
                        break;
                    case "2":
                        AccountServiceImpl.transfer(em, sc);
                        break;
                    case "3":
                        AccountServiceImpl.checkBalance(em, sc);
                        break;
                    default:
                        System.out.println("Wrong parameter!");
                        return;
                }
            }
        } finally {
            sc.close();
            em.close();
            emf.close();
        }

    }
}

