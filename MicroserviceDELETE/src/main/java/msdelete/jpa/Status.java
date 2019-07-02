package msdelete.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the status database table.
 * 
 */
@Entity
@NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STATUS_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STATUS_ID_GENERATOR")
	private Integer id;

	private String naziv;

	private String oznaka;

	//bi-directional many-to-one association to Student
	@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="statusBean")
	@JsonIgnore
	private List<Student> students;

	public Status() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOznaka() {
		return this.oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setStatusBean(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setStatusBean(null);

		return student;
	}

}