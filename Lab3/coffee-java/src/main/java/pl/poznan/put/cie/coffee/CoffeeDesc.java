package pl.poznan.put.cie.coffee;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

class CreateCoffeeDesc{
    private static SessionFactory sessionFactory;

    public static void main( String[ ] args ) {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        CreateCoffeeDesc createCoffe = new CreateCoffeeDesc();
        createCoffe.addCoffeDesc("Colombian", "test");

    }

    /* Method to CREATE an employee in the database */
    public String addCoffeDesc(String name, String description){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        String coffeDescriptionID = null;

        try {
            tx = session.beginTransaction();
            CoffeeDescriptionsEntity coffeeDescription = new CoffeeDescriptionsEntity();
            coffeeDescription.setCofName(name);
            coffeeDescription.setCofDesc(description);

            coffeDescriptionID = (String) session.save(coffeeDescription);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return coffeDescriptionID;
    }

}