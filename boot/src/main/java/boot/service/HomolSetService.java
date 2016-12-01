package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.HomolSetRepository;
import boot.model.HomolSet;

@Service @Transactional
public class HomolSetService {


	private final HomolSetRepository homolSetRepository;

	public HomolSetService(HomolSetRepository homolSetRepository) {
		super();
		this.homolSetRepository = homolSetRepository;
	}
	public List<HomolSet> findAll(){
		List<HomolSet> homolSets = new ArrayList<HomolSet>();
		for (HomolSet homolSet : homolSetRepository.findAll()) {
			homolSets.add(homolSet);
		}
		return homolSets;
	}
	
	public void save(HomolSet homolSet){
		homolSetRepository.save(homolSet);
	}
	
	public void delete(int id){
		homolSetRepository.delete(id);
	}
	
	public HomolSet findHomolSet(int id){
		return homolSetRepository.findOne(id);
	}
	
}
