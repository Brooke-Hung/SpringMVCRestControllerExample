package com.brookehung.springmvcrestcontroller.service;

import java.util.List;

/**
 * @author Brooke
 * @since JDK1.8
 * @created on 2018/06/28
 */
public interface Service<T, ESC, PK> {
	
	public T getById(PK id);
	public List<T> search(ESC sc);
	public PK insert(T t);
	public int delete(PK id);
	public int update(T t);

}
