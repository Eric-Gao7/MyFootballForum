package dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;


import impl.TopicDAO_impl;


public class tao {

	private static TopicDAO topicDao = null;

	static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("DataSource");

	public static TopicDAO getTopic_DAO() {
		if (topicDao == null) {

			topicDao = new TopicDAO_impl(pmf);
		}

		return topicDao;
	}

	

}
