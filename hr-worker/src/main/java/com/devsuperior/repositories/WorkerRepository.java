package com.devsuperior.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.entities.Worker;

@Repository
public interface WorkerRepository  extends JpaRepository<Worker, Long>{

}
