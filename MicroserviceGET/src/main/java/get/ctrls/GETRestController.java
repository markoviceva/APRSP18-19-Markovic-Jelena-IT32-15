package get.ctrls;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import get.reps.FakultetRepository;
import io.swagger.annotations.ApiOperation;
import get.jpa.Status;
import get.reps.StatusRepository;
import get.jpa.Student;
import get.reps.StudentRepository;
import get.jpa.Departman;
import get.reps.DepartmanRepository;
import get.jpa.Fakultet;



@RestController
public class GETRestController {
	
	@Autowired
	private FakultetRepository fakultetRepository;
	
	@Autowired
	private DepartmanRepository departmanRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@GetMapping("fakultet")
	@ApiOperation(value = "Vraca kolekciju svih fakulteta iz baze podataka")
	public Collection<Fakultet> getFakulteti(){
		return fakultetRepository.findAll();
	}
	
	@GetMapping("fakultetId/{id}")
	@ApiOperation(value = "Vraca artikl iz baze podataka ciji je ID vrednost prosledjena kao path variabla")
	public Fakultet getFakultet(@PathVariable("id") Integer id) {
		return fakultetRepository.getOne(id);
	}
	
	@GetMapping("fakultetNaziv/{naziv}")
	@ApiOperation(value = "Vraca fakultet iz baze ciji je naziv vrednost prosledjena kao path variabla")
	public Collection<Fakultet> getFakultetByName(@PathVariable("naziv") String naziv) {
		return fakultetRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@GetMapping("departman")
	@ApiOperation(value="Vraca kolekciju svih departmana iz baze podataka")
	public Collection<Departman> getDepartmani(){
		return departmanRepository.findAll();
	}
	
	@GetMapping("departmanId/{id}")
	@ApiOperation(value="Vraca departman ciji je id jednak id-u proslednjenom kao path varijabla")
	public Departman getDepartman(@PathVariable ("id") Integer id) {
		return departmanRepository.getOne(id);
	}
	
	@GetMapping("departmanNaziv/{naziv}")
	@ApiOperation(value = "Vraca departman ciji je naziv jednak nazivu proslednjenom kao path varijabla")
	public Collection<Departman> getDepartmanByNaziv(@PathVariable ("naziv") String naziv){
		return departmanRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@GetMapping("departmanFakultet/{id}")
	public Collection<Departman> getDepartmanByFakultet(@PathVariable ("id") Integer id){
		Fakultet f = fakultetRepository.getOne(id);
		return departmanRepository.findByFakultetBean(f);
	}
	
	@GetMapping("student")
	@ApiOperation(value="Vraca kolekciju svih studenata iz baze podataka")
	public Collection<Student> getStudenti(){
		return studentRepository.findAll();
	}
	
	@GetMapping("studentId/{id}")
	@ApiOperation(value="Vraca studenta iz baze podataka na osnovu prosledjenog id-ja kroz path varijablu")
	public Student getStudent(@PathVariable ("id") Integer id) {
		return studentRepository.getOne(id);
	}
	
	@GetMapping("studentiDepartmana/{id}")
	@ApiOperation(value="Vraca studente koji studiraju na departmanu koji ima prosledjen id kroz path varijablu")
	public Collection<Student> getStudentiDepartmana(@PathVariable ("id") Integer id){
		Departman d = departmanRepository.getOne(id);
		return studentRepository.findByDepartmanBean(d);
	}
	
	@GetMapping("status")
	@ApiOperation(value="Vraca kolekciju svih statusa iz baze podataka")
	public Collection<Status> getStatusi(){
		return statusRepository.findAll();
	}
	
	@GetMapping("statusId/{id}")
	@ApiOperation(value="Vraca status na osnovu prosledjenog id-ja kroz path varijablu ")
	public Status getStatus(@PathVariable ("id") Integer id) {
		return statusRepository.getOne(id);
	}
	
	@GetMapping("statusNaziv/{naziv}")
	@ApiOperation(value="Vraca status na osnovu prosledjenog naziva statusa kroz path varijablu")
	public Collection<Status> getStatusByNaziv(@PathVariable("naziv") String naziv){
		return statusRepository.findByNazivContainingIgnoreCase(naziv);
	}

	
}
