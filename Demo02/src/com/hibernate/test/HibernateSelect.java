package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.entity.User;
import com.hibernate.utils.HibernateUtils;

public class HibernateSelect {
	//事务规范代码
	@Test
	public void testTx() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			User user = new User();
			user.setUsername("小明2");
			user.setPassword("456");
			user.setAddress("c区");
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
