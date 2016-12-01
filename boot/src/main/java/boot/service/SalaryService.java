package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.SalaryRepository;
import boot.model.Salary;



@Service @Transactional
public class SalaryService {
	private final SalaryRepository salaryRepository;

	public SalaryService(SalaryRepository salaryRepository) {
		super();
		this.salaryRepository = salaryRepository;
	}
	public List<Salary> findAll(){
		List<Salary> salaries = new ArrayList<Salary>();
		for (Salary salary : salaryRepository.findAll()) {
			salaries.add(salary);
		}
		return salaries;
	}
	
	public void save(Salary salary){
		salaryRepository.save(salary);
	}
	
	public void delete(int id){
		salaryRepository.delete(id);
	}
	
	public Salary findSalary(int id){
		return salaryRepository.findOne(id);
	}
	
}
