package com.example.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Person;
import com.example.repository.PersonRepository;

@Service
public class CalendarService {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private CalendarDataDaoImpl calendarDaoImpl;
	
	//全件検索
	public List<Person> findAll(){
		return personRepository.findAll();
	}
    //該当のID見つける
    public Optional<Person> findById(long isbn) {
        return personRepository.findById(isbn);
    }

	
	//検索
	public List<Person> search(String title, String start, String end1 ){
		List<Person> result = new ArrayList<Person>();
		
		if("".equals(title) && "".equals(start) && "".equals(end1)) {
			result = personRepository.findAll();
		}
		else {
			result = calendarDaoImpl.search(title, start, end1);
		}
		return result;
	}
}
