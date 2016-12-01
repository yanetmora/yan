package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.DeptManagerRepository;
import boot.model.DeptManager;



@Service @Transactional
public class DeptManagerService {

	private final DeptManagerRepository deptManagerRepository;

	public DeptManagerService(DeptManagerRepository deptManagerRepository) {
		super();
		this.deptManagerRepository = deptManagerRepository;
	}
	public List<DeptManager> findAll(){
		List<DeptManager> deptManagers = new ArrayList<DeptManager>();
		for (DeptManager deptManager : deptManagerRepository.findAll()) {
			deptManagers.add(deptManager);
		}
		return deptManagers;
	}
	
	public void save(DeptManager deptManager){
		deptManagerRepository.save(deptManager);
	}
	
	public void delete(int deptNo){
		deptManagerRepository.delete(deptNo);
	}
	
	public DeptManager findDeptManager(int deptNo){
		return deptManagerRepository.findOne(deptNo);
	}
	
}
