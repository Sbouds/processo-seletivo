package br.com.douglasfs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.douglasfs.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

}
