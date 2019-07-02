package post.ctrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import post.reps.DepartmanRepository;
import post.reps.FakultetRepository;
import post.reps.StatusRepository;
import post.reps.StudentRepository;
import post.jpa.Student;
import post.jpa.Status;
import post.jpa.Departman;
import post.jpa.Fakultet;



@RestController
public class PostRestController {
	@Autowired
	private FakultetRepository fakultetRepository;
	
	@Autowired
	private DepartmanRepository departmanRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@PostMapping("fakultet")
	@ApiOperation(value="Upisuje fakultet u bazu podataka")
	public ResponseEntity<HttpStatus> insertFakultet(@RequestBody Fakultet fakultet){
		if(fakultetRepository.existsById(fakultet.getId()))
			return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);
		fakultetRepository.save(fakultet);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@PostMapping("departman")
	@ApiOperation(value = "Upisuje departman u bazu")
	public ResponseEntity<Departman> insertDepartman(@RequestBody Departman departman){
		if(!departmanRepository.existsById(departman.getId())) {
			departmanRepository.save(departman);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@PostMapping("status")
	@ApiOperation(value="Ubacuje status u bazu")
	public ResponseEntity<Status> insertStatus(@RequestBody Status status){
		if(!statusRepository.existsById(status.getId())) {
			statusRepository.save(status);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@PostMapping("student")
	@ApiOperation(value="Upisuje studenta u bazu podataka")
	public ResponseEntity<Student> insertStudent(@RequestBody Student student){
		if(!studentRepository.existsById(student.getId())) {
			studentRepository.save(student);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
}
