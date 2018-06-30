package com.brookehung.springmvcrestcontroller.web.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Utilities for generating ResponseEntity
 * @author Brooke
 * @since JDK1.8
 * @created on 2018/06/30
 */
public class RestControllerUtils {

	public static <PK> ResponseEntity<PK> generateResponseEntityForInsert(PK id) {
		HttpStatus httpStatus;
		if (id != null) {
			httpStatus = HttpStatus.CREATED;
		} else {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<PK>(id, httpStatus);
	}
	
	public static ResponseEntity<Integer> generateResponseEntityForUpdate(int rs) {
		HttpStatus httpStatus;
		if (rs == 1) {
			httpStatus = HttpStatus.OK;
		} else {
			httpStatus = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<Integer>(rs, httpStatus);
	}
	
	public static <T> ResponseEntity<T> generateResponseEntityForGet(T t){
		HttpStatus httpStatus;
		if (t == null) {
			httpStatus = HttpStatus.NOT_FOUND;
		} else {
			httpStatus = HttpStatus.OK;
		}
		return new ResponseEntity<T>(t, httpStatus);
	}
	
	public static <T> ResponseEntity<List<T>> generateResponseEntityForSearch(List<T> list){
		HttpStatus httpStatus;
		if (CollectionUtils.isEmpty(list)) {
			httpStatus = HttpStatus.NOT_FOUND;
		} else {
			httpStatus = HttpStatus.OK;
		}
		return new ResponseEntity<List<T>>(list, httpStatus);
	}
	
	public static <T> ResponseEntity<T> generateResponseEntityForUnsupportedOperations(){
		return new ResponseEntity<T>(HttpStatus.METHOD_NOT_ALLOWED);
	}

}
