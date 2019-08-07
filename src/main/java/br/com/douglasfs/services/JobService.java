package br.com.douglasfs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.douglasfs.domain.Job;
import br.com.douglasfs.repositories.JobRepository;
import br.com.douglasfs.services.exceptions.DataIntegrityException;


@Service
public class JobService {
	
	@Autowired
	private JobRepository jobRepository;
	
	public Job find(Integer id) {		
		Optional<Job> obj = jobRepository.findById(id);		
		return obj.orElseThrow(() -> new br.com.douglasfs.services.exceptions.ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id));
	}

	public List<Job> findAll(){
		return jobRepository.findAll();		
	}
	
	public Job insert(Job obj) {
		obj.setId(null);
		return jobRepository.save(obj);
	}
	
	public Job update(Job obj) {
		find(obj.getId());
		return jobRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			jobRepository.deleteById(id);
		} 
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um Job que possui uma ou mais Task");
		}
	}
}
