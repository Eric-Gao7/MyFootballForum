package impl;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import dao.Topic;
import dao.TopicDAO;
import dao.User;

public class TopicDAO_impl implements TopicDAO {
	private PersistenceManagerFactory pmf;

	public TopicDAO_impl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}
	
	public long addTopic(Topic top) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		top = pm.makePersistent(top);
		pm.close();
		return top.getId();
	}
	
	public List<Topic> getTopic() {
	//TODO Auto-generated method stub
	List<Topic> actions = null;
	List<Topic> detached = null;
	PersistenceManager pm = pmf.getPersistenceManager();
	javax.jdo.Transaction tx = pm.currentTransaction();
	try {
		((javax.jdo.Transaction) tx).begin();
		javax.jdo.Query q = pm.newQuery(Topic.class);
		actions = (List<Topic>) q.execute();
		detached = (List<Topic>) pm.detachCopyAll(actions);
		tx.commit();
	} finally {
		if (((javax.jdo.Transaction) tx).isActive()) {
			tx.rollback();
		}
		pm.close();
	}
	return detached;
	}

}
