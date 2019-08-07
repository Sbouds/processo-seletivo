package br.com.douglasfs.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.douglasfs.domain.Job;
import br.com.douglasfs.services.JobService;

@RestController
@RequestMapping(value = "/jobs")
public class JobResource {
	
	@Autowired
	private JobService jobService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Job>> findAll() {
		List<Job> list = jobService.findAll();
		return (ResponseEntity.ok().body(list));
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Job> find(@PathVariable Integer id) {
		Job obj = jobService.find(id);		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Job obj) {
		obj = jobService.insert(obj);		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Job obj, @PathVariable Integer id){
		obj.setId(id);
		obj = jobService.update(obj);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		jobService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
