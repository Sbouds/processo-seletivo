package br.com.douglasfs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.douglasfs.domain.Job;

public interface JobRepository extends JpaRepository<Job, Integer>{

}
