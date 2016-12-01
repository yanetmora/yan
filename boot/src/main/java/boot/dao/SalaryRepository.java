package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Salary;



public interface SalaryRepository extends CrudRepository<Salary, Integer>{

}
