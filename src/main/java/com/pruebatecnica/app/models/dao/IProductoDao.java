package com.pruebatecnica.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.pruebatecnica.app.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{


}
