package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.entity.Customer;
import com.hibernate.entity.LinkMan;
import com.hibernate.utils.HibernateUtils;

public class HibernateOneToMany {
	@Test
	public void oneToManyUpdateTest() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			Customer baidu = session.get(Customer.class, 2);
			LinkMan luck = session.get(LinkMan.class, 1);
			
			baidu.getSetLinkMan().add(luck);
			luck.setCustomer(baidu);
			
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
	public void oneToManyDeleteTest() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			Customer customer = session.get(Customer.class, 5);
			session.delete(customer);
			
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
	public void oneToMany2Test() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			Customer customer = new Customer();
			customer.setCustName("传智播客");
			customer.setCustLevel("vip");
			customer.setCustSource("网络");
			customer.setCustPhone("123");
			customer.setMobile("456");
			
			LinkMan linkMan = new LinkMan();
			linkMan.setLkm_name("lucy");
			linkMan.setLkm_gender("男");
			linkMan.setLkm_phone("321");
			
			customer.getSetLinkMan().add(linkMan);
			session.save(customer);
			
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
	public void oneToManyTest() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			Customer customer = new Customer();
			customer.setCustName("传智播客");
			customer.setCustLevel("vip");
			customer.setCustSource("网络");
			customer.setCustPhone("123");
			customer.setMobile("456");
			
			LinkMan linkMan = new LinkMan();
			linkMan.setLkm_name("lucy");
			linkMan.setLkm_gender("男");
			linkMan.setLkm_phone("321");
			
			customer.getSetLinkMan().add(linkMan);
			linkMan.setCustomer(customer);
			session.save(customer);
			session.save(linkMan);
			
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
