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
 * Home object for domain model class BatchJobInstance.
 * @see com.david.entity.h2.BatchJobInstance
 * @author Hibernate Tools
 */
public class BatchJobInstanceHome {

	private static final Log log = LogFactory.getLog(BatchJobInstanceHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(BatchJobInstance transientInstance) {
		log.debug("persisting BatchJobInstance instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(BatchJobInstance instance) {
		log.debug("attaching dirty BatchJobInstance instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BatchJobInstance instance) {
		log.debug("attaching clean BatchJobInstance instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(BatchJobInstance persistentInstance) {
		log.debug("deleting BatchJobInstance instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BatchJobInstance merge(BatchJobInstance detachedInstance) {
		log.debug("merging BatchJobInstance instance");
		try {
			BatchJobInstance result = (BatchJobInstance) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public BatchJobInstance findById(java.lang.Long id) {
		log.debug("getting BatchJobInstance instance with id: " + id);
		try {
			BatchJobInstance instance = (BatchJobInstance) sessionFactory.getCurrentSession()
					.get("com.david.entity.h2.BatchJobInstance", id);
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

	public List findByExample(BatchJobInstance instance) {
		log.debug("finding BatchJobInstance instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.david.entity.h2.BatchJobInstance")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
