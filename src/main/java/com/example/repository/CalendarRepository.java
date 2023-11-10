package com.example.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Calendar;

@Repository
public interface CalendarRepository  extends JpaRepository<Calendar, Long> {
  public Optional<Calendar> findById(Long id);
}

