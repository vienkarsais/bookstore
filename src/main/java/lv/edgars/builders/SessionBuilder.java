package lv.edgars.builders;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionBuilder {

    private static SessionBuilder instance;
    protected SessionFactory sessionFactory;

    protected SessionBuilder() {
        this.sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static SessionBuilder getInstance(){
        if (instance == null){
            SessionBuilder.instance = new SessionBuilder();
        }
        return instance;
    }

    public Session build(){
        Session sessionInit = this.sessionFactory.openSession();
        Session session = sessionInit.getSession();
        return session;

    }
}
