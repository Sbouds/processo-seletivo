package br.com.douglasfs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.douglasfs.domain.Task;
import br.com.douglasfs.repositories.TaskRepository;


@Service
public class TaskService {
	
	@Autowired
	private TaskRepository jobRepository;
	
	public Task find(Integer id) {
		Optional<Task> obj = jobRepository.findById(id);
		return obj.orElse(null);
	}

	public List<Task> findAll(){
		return jobRepository.findAll();		
	}
	
}
