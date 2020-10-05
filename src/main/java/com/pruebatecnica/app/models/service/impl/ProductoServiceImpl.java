package com.pruebatecnica.app.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebatecnica.app.models.dao.IProductoDao;
import com.pruebatecnica.app.models.entity.Producto;
import com.pruebatecnica.app.models.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoDao productoDao;
	
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return (List<Producto>) productoDao.findAll();
	}

	@Transactional
	public void save(Producto producto) {
		productoDao.save(producto);
		
	}

	@Transactional(readOnly = true)
	public Producto findOne(Long id) {
		// TODO Auto-generated method stub
		return productoDao.findById(id).orElse(null);
	}

	@Transactional
	public void delete(Long id) {
		productoDao.deleteById(id);
		
	}
}
