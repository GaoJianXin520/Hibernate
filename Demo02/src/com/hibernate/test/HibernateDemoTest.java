package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.entity.User;
import com.hibernate.utils.HibernateUtils;

public class HibernateDemoTest {
	@Test
	public void saveOrUpdateTest() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		User user = new User();
		user.setUsername("大明");
		user.setPassword("456");
		user.setAddress("b区");
		session.saveOrUpdate(user);
		
		tx.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void deleteUserTest() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		//delete from t_user where uid = 5;
		User user = session.get(User.class, 5);
		session.delete(user);
		
		//第二种
		/*User user2 = new User();
		user2.setUid(5);
		session.delete(user);*/
		
		tx.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void updateUserTest() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		//update t_uer set username = "xiaoming" and uid = 1;
		User user = session.get(User.class,  1);
		user.setUsername("小明");
		session.update(user);
		
		tx.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void getUserByIdTest() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		//select * from t_user t where t.uid = 2;
		User user = session.get(User.class, 2);
		System.out.println("getUserById----------" + user);
		
		tx.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void addTest() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		User user = new User();
		user.setUsername("小红");
		user.setPassword("132");
		user.setAddress("b区");
		session.save(user);
		
		tx.commit();
		session.close();
		sessionFactory.close();
	}
}
