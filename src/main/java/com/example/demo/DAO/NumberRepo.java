package com.example.demo.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.NumberBase;

@Repository
public interface NumberRepo extends CrudRepository<NumberBase, Long> {
	

}
