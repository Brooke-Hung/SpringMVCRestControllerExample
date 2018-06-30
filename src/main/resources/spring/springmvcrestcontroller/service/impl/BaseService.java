package com.brookehung.springmvcrestcontroller.service.impl;

import java.util.List;

import com.brookehung.springmvcrestcontroller.service.Service;

/**
 * Dummy Implementation for Demo Purposes
 * @author Brooke
 * @since JDK1.8
 * @created on 2018/06/28
 */
public abstract class BaseService<T, ESC, PK> implements Service<T, ESC, PK>{

	public T getById(PK id) {
		throw new UnsupportedOperationException();
	}

	public List<T> search(ESC sc) {
		throw new UnsupportedOperationException();
	}

	public PK insert(T t) {
		throw new UnsupportedOperationException();
	}

	public int delete(PK id) {
		throw new UnsupportedOperationException();
	}

	public int update(T t) {
		throw new UnsupportedOperationException();
	}

}
