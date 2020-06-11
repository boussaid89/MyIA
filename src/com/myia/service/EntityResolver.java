package com.myia.service;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

public class EntityResolver<T> {
	
	private Class<T> entityClass;
private Session               session ;
	/**
	 * @param entityClass
	 */
	public EntityResolver(Class<T> entityClass) {
 		this.setEntityClass(entityClass);
	}


	public EntityResolver()  {
		
	}
	
	@PreDestroy
	public void close() {
		if(session!=null)
		this.session.close();
	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass2 the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass2) {
		this.entityClass = entityClass2;
	}

	
	@SuppressWarnings("unused")
	public T findByAttribute(String attribute,String value) {
		T result=null;
		if(session==null)
		    session      = Mapping.getSession();
		CriteriaBuilder       builder      = session.getCriteriaBuilder();
		CriteriaQuery<T> query        = builder.createQuery(entityClass);
		Root<T>          root         = query.from(entityClass);
		Predicate             restrictions = builder.equal(root.get(attribute), value);
		query.where(restrictions);
		try {
		List<T> rs=session.createQuery(query).getResultList();
 		result=rs!=null && rs.size()>0?rs.get(0):null;
		}catch (Exception ex) {
			// TODO: handle exception
		}
		 session.close();
		return result;
	}
	
	@SuppressWarnings("unused")
	public List<T> findListByAttribute(String attribute,String value)  {
		if(session==null)
	                session      = Mapping.getSession();
		CriteriaBuilder       builder      = session.getCriteriaBuilder();
		CriteriaQuery<T> query        = builder.createQuery(entityClass);
		Root<T>          root         = query.from(entityClass);
		Predicate             restrictions = builder.equal(root.get(attribute), value);
		query.where(restrictions);
		 List<T> result=session.createQuery(query).getResultList();
		 session.close();
		return result;
		}
	
	@SuppressWarnings("unused")
	public T findByName(String name) {
		T result=null;
if(session==null)
   session      = Mapping.getSession();
		CriteriaBuilder       builder      = session.getCriteriaBuilder();
		CriteriaQuery<T> query        = builder.createQuery(entityClass);
		Root<T>          root         = query.from(entityClass);
		Predicate             restrictions = builder.equal(root.get("name"), name);
		query.where(restrictions);
		try {
			List<T> rs=session.createQuery(query).getResultList();
	 		result=rs!=null && rs.size()>0?rs.get(0):null;
			}catch (Exception ex) {
				// TODO: handle exception
			}
		session.close();
		return result;
	}
	
	@SuppressWarnings("unused")
	public List<T> findListByName(String name ) {
		if(session==null)
             session      = Mapping.getSession();
		CriteriaBuilder       builder      = session.getCriteriaBuilder();
		CriteriaQuery<T> query        = builder.createQuery(entityClass);
		Root<T>          root         = query.from(entityClass);
		Predicate             restrictions = builder.equal(root.get("name"), name);
		query.where(restrictions);
		 List<T> result=session.createQuery(query).getResultList();
		 session.close();
		return result;
	}
	
	@SuppressWarnings("unused")
	public List<T> findAll(Class c) {
		if(session==null)
        session = Mapping.getSession();
		CriteriaBuilder       builder = session.getCriteriaBuilder();
		CriteriaQuery<T> query   = builder.createQuery(entityClass);
		Root<T>          root    = query.from(c);
		 List<T> result=session.createQuery(query).getResultList();
		 session.close();
		return result;
	}
	
	@SuppressWarnings("unused")
	public List<T> filter(Class c, Predicate restrictions) {
		if(session==null)
         session = Mapping.getSession();
		CriteriaBuilder       builder = session.getCriteriaBuilder();
		CriteriaQuery<T> query   = builder.createQuery(entityClass);
		Root<T>          root    = query.from(entityClass);
		query.where(restrictions);
		 List<T> result=session.createQuery(query).getResultList();
		 session.close();
		return result;
	}
	
	@SuppressWarnings("unused")
	public void save(T obj) {
		  session = Mapping.getSession();
		session.getTransaction().begin();
		session.saveOrUpdate(obj);
		session.getTransaction().commit();
		session.close();
	}
	
	@SuppressWarnings("unused")
	public void save(T[] obj) {
		  session = Mapping.getSession();
		for (T o : obj) {
			session.getTransaction().begin();
			session.saveOrUpdate(o);
			session.getTransaction().commit();
		}
		session.close();
	}
	
		
	@SuppressWarnings("unused")
	public void delete(T obj) {
		 session = Mapping.getSession();
		session.getTransaction().begin();
		session.remove(obj);
		session.getTransaction().commit();
		session.close();
	}
	
	@SuppressWarnings("unused")
	public void delete(T[] obj) {
		  session = Mapping.getSession();
		for (T o : obj) {
			session.getTransaction().begin();
			session.remove(obj);
			session.getTransaction().commit();
		}
		session.close();
	}
 
	
	
	
	
}
