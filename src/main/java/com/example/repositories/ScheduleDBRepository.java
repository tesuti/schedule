package com.example.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.database.ScheduleDB;

public class ScheduleDBRepository {
	@Repository
	public interface scheduleDBRepository extends JpaRepository<ScheduleDB, Long> {
		public Optional<ScheduleDB> findById(Long name);

		public List<ScheduleDB> findByNameLike(String name);

		public List<ScheduleDB> findByIdIsNotNullOrderByIdDesc();

		public List<ScheduleDB> findByAgeGreaterThan(Integer age);

		public List<ScheduleDB> findByAgeBetween(Integer age1, Integer age2);
	}//作っただけ
}
