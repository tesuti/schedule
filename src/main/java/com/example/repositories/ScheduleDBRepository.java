package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.database.ScheduleDB;

public class ScheduleDBRepository {
	@Repository
	public interface ScheduleDBRepository extends JpaRepository<ScheduleDB, Long> {
		public Optional<ScheduleDB> findById(Long name);

		public List<Person> findByNameLike(String name);

		public List<Person> findByIdIsNotNullOrderByIdDesc();

		public List<Person> findByAgeGreaterThan(Integer age);

		public List<Person> findByAgeBetween(Integer age1, Integer age2);
	}//作っただけ
}
