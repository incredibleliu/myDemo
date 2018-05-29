package com.david.manager;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Component;

import com.david.entity.h2.BatchJobInstance;

/**
 * Created by WS on 20/1/17.
 */
@Component
public class JobInstanceManager {

    private SessionFactory sessionFactory;

    //Copied from - http://docs.jboss.org/hibernate/orm/current/quickstart/html_single/
    //configures settings from hibernate.cfg.xml
    @PostConstruct
    public void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    public void close(){
        sessionFactory.close();
    }


//    /***
//     * This method insers the record in the table
//     */
//    public void createRecord(Book book){
//
//        //E.g. Request can contain below sample data in book object to insert in the bookStore table
//        //Book book = new Book();
//        //book.setAuthor("Waqar Syed");
//        //book.setPrice(1000);
//        //book.setTitle("Hibernate Sample");
//
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(book);
//        session.getTransaction().commit();
//        session.close();
//    }

    /***
     * This method is to retrieve records from table
     */
    public BatchJobInstance readRecord(Long id){

        Session session = sessionFactory.openSession();

        BatchJobInstance job = session.get(BatchJobInstance.class, id);

        if(job != null){
            System.out.println( "job name ="+ job.getJobName());
//            System.out.println( "Title from Table="+book.getTitle());
        }
        session.close();

        return job;
    }

}