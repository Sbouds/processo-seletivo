package br.com.douglasfs.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.douglasfs.domain.Task;
import br.com.douglasfs.services.TaskService;

@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Task>> findAll() {
		List<Task> list = taskService.findAll();
		return (ResponseEntity.ok().body(list));
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Task> find(@PathVariable Integer id) {
		Task obj = taskService.find(id);		
		return ResponseEntity.ok().body(obj);
	}
}
