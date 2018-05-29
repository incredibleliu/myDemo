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
 * Home object for domain model class BatchStepExecution.
 * @see com.david.entity.h2.BatchStepExecution
 * @author Hibernate Tools
 */
public class BatchStepExecutionHome {

	private static final Log log = LogFactory.getLog(BatchStepExecutionHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(BatchStepExecution transientInstance) {
		log.debug("persisting BatchStepExecution instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(BatchStepExecution instance) {
		log.debug("attaching dirty BatchStepExecution instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BatchStepExecution instance) {
		log.debug("attaching clean BatchStepExecution instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(BatchStepExecution persistentInstance) {
		log.debug("deleting BatchStepExecution instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BatchStepExecution merge(BatchStepExecution detachedInstance) {
		log.debug("merging BatchStepExecution instance");
		try {
			BatchStepExecution result = (BatchStepExecution) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public BatchStepExecution findById(java.lang.Long id) {
		log.debug("getting BatchStepExecution instance with id: " + id);
		try {
			BatchStepExecution instance = (BatchStepExecution) sessionFactory.getCurrentSession()
					.get("com.david.entity.h2.BatchStepExecution", id);
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

	public List findByExample(BatchStepExecution instance) {
		log.debug("finding BatchStepExecution instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.david.entity.h2.BatchStepExecution")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
