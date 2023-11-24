package com.example.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class CalendarDataDaoImpl implements CalendarDataDao{

	@Autowired
	private EntityManager entityManager;
	
	public CalendarDataDaoImpl() {
		super();
	}
	
	public CalendarDataDaoImpl(EntityManager manager) {
		this();
		entityManager = manager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> search(String title, String start, String end1) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT b From Person b WHERE ");
		
		boolean titleFlg = false;
		boolean startFlg = false;
		boolean endFlg   = false;
		boolean andFlg   = false;
		
		//
		if(!"".equals(title)) {
			sql.append("b.title LIKE :title");
			titleFlg = true;
			andFlg   = true;
		}
		
		if(!"".equals(start)) {
			if(andFlg)sql.append(" AND ");
			sql.append("b.start LIKE : start");
			startFlg = true;
			andFlg   = true;
		}
		
		if(!"".equals(end1)) {
			if(andFlg) sql.append(" AND ");
			sql.append("b.end1 LIKE :end1");
			endFlg = true;
			andFlg = true;
		}
		
		Query query = entityManager.createQuery(sql.toString());
		
		//上記でtrueになった場合は、各変数に値をセットする。
		if(titleFlg) query.setParameter("title","%" + title + "%");
		if(startFlg) query.setParameter("start","%" + start + "%");
		if(endFlg) query.setParameter("end1","%" + end1 + "%");
		
		
		return query.getResultList();
	}

	
}
