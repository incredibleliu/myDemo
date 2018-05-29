package com.david.entity.h2;
// Generated 2018-5-29 1:37:48 by Hibernate Tools 5.3.0.Beta2

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class BatchJobExecutionContext.
 * @see com.david.entity.h2.BatchJobExecutionContext
 * @author Hibernate Tools
 */
public class BatchJobExecutionContextHome {

	private static final Log log = LogFactory.getLog(BatchJobExecutionContextHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(BatchJobExecutionContext transientInstance) {
		log.debug("persisting BatchJobExecutionContext instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(BatchJobExecutionContext instance) {
		log.debug("attaching dirty BatchJobExecutionContext instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BatchJobExecutionContext instance) {
		log.debug("attaching clean BatchJobExecutionContext instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(BatchJobExecutionContext persistentInstance) {
		log.debug("deleting BatchJobExecutionContext instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BatchJobExecutionContext merge(BatchJobExecutionContext detachedInstance) {
		log.debug("merging BatchJobExecutionContext instance");
		try {
			BatchJobExecutionContext result = (BatchJobExecutionContext) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public BatchJobExecutionContext findById(long id) {
		log.debug("getting BatchJobExecutionContext instance with id: " + id);
		try {
			BatchJobExecutionContext instance = (BatchJobExecutionContext) sessionFactory.getCurrentSession()
					.get("com.david.entity.h2.BatchJobExecutionContext", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(BatchJobExecutionContext instance) {
		log.debug("finding BatchJobExecutionContext instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.david.entity.h2.BatchJobExecutionContext").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
