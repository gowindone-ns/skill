package edu.learning.spring.model;

// Generated Feb 24, 2014 7:30:55 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class UserProfile.
 * @see edu.learning.spring.model.UserProfile
 * @author Hibernate Tools
 */
public class UserProfileHome {

	private static final Log log = LogFactory.getLog(UserProfileHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(UserProfile transientInstance) {
		log.debug("persisting UserProfile instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(UserProfile instance) {
		log.debug("attaching dirty UserProfile instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserProfile instance) {
		log.debug("attaching clean UserProfile instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(UserProfile persistentInstance) {
		log.debug("deleting UserProfile instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserProfile merge(UserProfile detachedInstance) {
		log.debug("merging UserProfile instance");
		try {
			UserProfile result = (UserProfile) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserProfile findById(edu.learning.spring.model.UserProfileId id) {
		log.debug("getting UserProfile instance with id: " + id);
		try {
			UserProfile instance = (UserProfile) sessionFactory
					.getCurrentSession().get(
							"edu.learning.spring.model.UserProfile", id);
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

	public List<UserProfile> findByExample(UserProfile instance) {
		log.debug("finding UserProfile instance by example");
		try {
			List<UserProfile> results = (List<UserProfile>) sessionFactory
					.getCurrentSession()
					.createCriteria("edu.learning.spring.model.UserProfile")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
