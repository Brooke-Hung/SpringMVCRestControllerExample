package com.brookehung.springmvcrestcontroller.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * Base RestController for Details
 * @author Brooke
 * @since JDK1.8
 * @created on 2018/06/30
 */
public abstract class BaseDetailsRestController<T, PK, DummySearchCriteria, DummyEntitySearchCriteria> extends BaseRestController<T, PK, DummySearchCriteria, DummyEntitySearchCriteria> {

	@Override
	@GetMapping("")
	public ResponseEntity<T> getById(@PathVariable PK id) {
		return super.getById(id);
	}

	@Override
	@DeleteMapping("")
	public ResponseEntity<Integer> deleteById(@PathVariable PK id) {
		return super.deleteById(id);
	}

	@Override
	@PutMapping("")
	public ResponseEntity<Integer> update(@PathVariable PK id, T t) {
		return super.update(id, t);
	}

	@Override
	@GetMapping("/unsupported")
	public ResponseEntity<List<T>> search(DummySearchCriteria sc) {
		return RestControllerUtils.generateResponseEntityForUnsupportedOperations();
	}
	
}
