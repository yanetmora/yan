package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Title;


public interface TitleRepository extends CrudRepository<Title, Integer>{
}