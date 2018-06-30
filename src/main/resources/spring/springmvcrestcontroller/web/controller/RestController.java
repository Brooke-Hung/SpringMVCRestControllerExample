package com.brookehung.springmvcrestcontroller.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

/**
 * Interface for RestController
 * @author Brooke
 * @since JDK1.8
 * @created on 2018/06/28
 */
public interface RestController<T, PK, SC, ESC> {
	
	public ResponseEntity<T> getById(PK id);
	public ResponseEntity<List<T>> search(SC sc);
	public ResponseEntity<PK> insert(T t);
	public ResponseEntity<Integer> deleteById(PK id);
	public ResponseEntity<Integer> update(PK id, T t);

}
