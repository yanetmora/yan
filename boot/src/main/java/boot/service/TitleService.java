package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.TitleRepository;
import boot.model.Title;


@Service @Transactional
public class TitleService {
	

	private final TitleRepository titleRepository;

	public TitleService(TitleRepository titleRepository) {
		super();
		this.titleRepository = titleRepository;
	}
	public List<Title> findAll(){
		List<Title> titles = new ArrayList<Title>();
		for (Title title : titleRepository.findAll()) {
			titles.add(title);
		}
		return titles;
	}
	
	public void save(Title title){
		titleRepository.save(title);
	}
	
	public void delete(int empNo){
		titleRepository.delete(empNo);
	}
	
	public Title findTitle(int empNo){
		return titleRepository.findOne(empNo);
	}

}
