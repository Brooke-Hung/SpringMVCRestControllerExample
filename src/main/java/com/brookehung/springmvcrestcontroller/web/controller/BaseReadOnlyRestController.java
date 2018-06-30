package com.brookehung.springmvcrestcontroller.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * Base RestController for ReadOnly operations
 * @author Brooke
 * @since JDK1.8
 * @created on 2018/06/30
 */
public abstract class BaseReadOnlyRestController<T, PK, SC, ESC> extends BaseRestController<T, PK, SC, ESC> {

	@Override
	@PostMapping("")
	public ResponseEntity<PK> insert(T t) {
		return RestControllerUtils.generateResponseEntityForUnsupportedOperations();
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deleteById(@PathVariable PK id) {
		return RestControllerUtils.generateResponseEntityForUnsupportedOperations();
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Integer> update(@PathVariable PK id, T t) {
		return RestControllerUtils.generateResponseEntityForUnsupportedOperations();
	}

}
