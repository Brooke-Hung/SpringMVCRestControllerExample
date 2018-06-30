package com.brookehung.springmvcrestcontroller.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brookehung.springmvcrestcontroller.service.Service;

/**
 * Base Rest Controller with CRUD operations
 * @author Brooke
 * @since JDK1.8
 * @created on 2018/06/30
 */
@RequestMapping(value="/api/v1")
public abstract class BaseRestController<T, PK, SC, TC> implements RestController<T, PK, SC, TC> {

	@GetMapping(value = "/{id}")
	public ResponseEntity<T> getById(@PathVariable PK id) {
		T t = getService().getById(id);
		return RestControllerUtils.generateResponseEntityForGet(t);
	}	

	@GetMapping("")
	public ResponseEntity<List<T>> search(SC sc) {
		TC tc = convertSCToTC(sc);
		List<T> list = getService().search(tc);
		return RestControllerUtils.generateResponseEntityForSearch(list);
	}

	@PostMapping(value = "")
	public ResponseEntity<PK> insert(T t) {
		PK id = getService().insert(t);
		return RestControllerUtils.generateResponseEntityForInsert(id);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Integer> deleteById(@PathVariable PK id) {
		int rs = getService().delete(id);
		return RestControllerUtils.generateResponseEntityForUpdate(rs);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Integer> update(@PathVariable PK id, T t) {
		int rs = getService().update(t);
		return RestControllerUtils.generateResponseEntityForUpdate(rs);
	}
	
	protected TC convertSCToTC(SC sc){
		throw new UnsupportedOperationException();
	}
	
	protected abstract Service<T, TC, PK> getService();
	
}
