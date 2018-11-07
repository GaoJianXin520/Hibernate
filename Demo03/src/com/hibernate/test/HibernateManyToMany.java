package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.manytomany.Role;
import com.hibernate.manytomany.User;
import com.hibernate.utils.HibernateUtils;

public class HibernateManyToMany {
	@Test
	public void tableTest2() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			User user = session.get(User.class, 2);
			Role role = session.get(Role.class, 3);
			
			user.getSetRole().remove(role);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	@Test
	public void tableTest() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			User lucy = session.get(User.class, 1);
			Role role = session.get(Role.class, 1);
			
			lucy.getSetRole().add(role);
			session.save(lucy);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	@Test
	public void manyToManyDeleteTest() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			User user = session.get(User.class, 1);
			session.delete(user);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
			
		}
	}
	
	@Test
	public void manyToManyAddTest() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			User user1 = new User();
			user1.setUser_name("lucy");
			user1.setUser_password("123");
			
			User user2 = new User();
			user2.setUser_name("mary");
			user2.setUser_password("456");
			
			Role role1 = new Role();
			role1.setRole_name("总经理");
			role1.setRole_memo("总经理");
			
			Role role2 = new Role();
			role2.setRole_name("秘书");
			role2.setRole_memo("秘书");
			
			Role role3 = new Role();
			role3.setRole_name("保安");
			role3.setRole_memo("保安");
			
			user1.getSetRole().add(role1);
			user1.getSetRole().add(role2);
			
			user2.getSetRole().add(role2);
			user2.getSetRole().add(role3);
			
			session.save(user1);
			session.save(user2);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
