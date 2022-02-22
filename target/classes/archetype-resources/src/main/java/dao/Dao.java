package main.java.dao;

import java.util.List;

public interface Dao<T> {

	// save
	
	T save(T obj);
	
	// remove
	void remove(T obj);
	
	// update
	T update(T obj);
	
	// findbyId
	T findById(int id);
	
//	getall
	List<T> getAll();
}
