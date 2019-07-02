package msdelete.ctrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import msdelete.reps.DepartmanRepository;
import msdelete.reps.FakultetRepository;
import msdelete.reps.StatusRepository;
import msdelete.reps.StudentRepository;
import msdelete.jpa.Student;
import msdelete.jpa.Status;
import msdelete.jpa.Departman;
import msdelete.jpa.Fakultet;

@RestController
public class DELETERestController {
	
	@Autowired
	private FakultetRepository fakultetRepository;
	
	@Autowired
	private DepartmanRepository departmanRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@DeleteMapping("fakultet/{id}")
	@ApiOperation(value="Brise iz baze podataka fakultet ciji je id vrednost prosledjena kao path varijabla ")
	public ResponseEntity<Fakultet> deleteFakultet(@PathVariable("id") Integer id){
		if(fakultetRepository.existsById(id)) 
		{
			fakultetRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				
	}
	
	@DeleteMapping("departman/{id}")
	@ApiOperation(value = "Brise departman sa prosledjenim id-jem kao path varijablu")
	public ResponseEntity<Departman> deleteDepartman(@PathVariable ("id") Integer id){
		if(!departmanRepository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		departmanRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("status/{id}")
	@ApiOperation(value="Brise status iz baze podataka na osnovu prosledjenog id-ja kroz path varijablu")
	public ResponseEntity<Status> deleteStatus(@PathVariable ("id") Integer id){
		if(statusRepository.existsById(id)) {
			statusRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	@DeleteMapping("student/{id}")
	@ApiOperation(value="Brise studenta iz baze podataka na osnovu id-ja koji se prosledjuje kao path varijabla")
	public ResponseEntity<Student> deleteStudent(@PathVariable ("id") Integer id){
		if(!studentRepository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		studentRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
