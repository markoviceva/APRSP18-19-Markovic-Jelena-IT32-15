package put.ctrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import put.reps.DepartmanRepository;
import put.reps.FakultetRepository;
import put.reps.StatusRepository;
import put.reps.StudentRepository;
import put.jpa.Student;
import put.jpa.Status;
import put.jpa.Departman;
import put.jpa.Fakultet;



@RestController
public class PUTRestController {
	@Autowired
	private FakultetRepository fakultetRepository;
	
	@Autowired
	private DepartmanRepository departmanRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@PutMapping("fakultet")
	@ApiOperation(value="Modifikuje postojeci fakultet u bazi podataka")
	public ResponseEntity<HttpStatus> updateFakultet(@RequestBody Fakultet fakultet){
		if(fakultetRepository.existsById(fakultet.getId())) {
			fakultetRepository.save(fakultet);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("departman")
	@ApiOperation(value = "Modifikuje postojeci departman u bazi")
	public ResponseEntity<Departman> updateDepartman(@RequestBody Departman departman){
		if(!departmanRepository.existsById(departman.getId())) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		departmanRepository.save(departman);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@PutMapping("status")
	@ApiOperation(value="Modifikuje postojeci status u bazu podataka")
	public ResponseEntity<Status> updateStatus(@RequestBody Status status){
		if(statusRepository.existsById(status.getId())) {
			statusRepository.save(status);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("student")
	@ApiOperation(value="Modifikuje postojeceg studenta iz baze podataka")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student){
		if(!studentRepository.existsById(student.getId())) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		studentRepository.save(student);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
