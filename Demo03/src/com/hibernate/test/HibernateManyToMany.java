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
	public void mamyToManyTest() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			User user1 = new User();
			user1.setUser_name("小明1");
			user1.setUser_password("123456");
			
			User user2 = new User();
			user2.setUser_name("小明2");
			user2.setUser_password("654321");
			
			Role role1 = new Role();
			role1.setRole_name("司机");
			role1.setRole_memo("司机");
			
			Role role2 = new Role();
			role2.setRole_name("老师");
			role2.setRole_memo("老师");
			
			Role role3 = new Role();
			role3.setRole_name("学生");
			role3.setRole_memo("学生");
			
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
