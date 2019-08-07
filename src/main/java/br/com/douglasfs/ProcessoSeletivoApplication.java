package br.com.douglasfs;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.douglasfs.domain.Job;
import br.com.douglasfs.domain.Task;
import br.com.douglasfs.repositories.JobRepository;
import br.com.douglasfs.repositories.TaskRepository;

@SpringBootApplication
public class ProcessoSeletivoApplication implements CommandLineRunner{
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProcessoSeletivoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Job job1 = new Job(1, "Job1", true, null);
		Job job2 = new Job(2, "job2", true, null);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");		
		Task t1 = new Task(null, "fasfsa", 21, true, sdf.parse("30/09/2017 10:32"), job1);
		Task t2 = new Task(null, "hehehe", 3, true, sdf.parse("12/03/2017 10:32"), job1);
		
		job1.getTasks().addAll(Arrays.asList(t1));		
		
		jobRepository.saveAll(Arrays.asList(job1, job2));
		taskRepository.saveAll(Arrays.asList(t1,t2));
		
				
	}

}
