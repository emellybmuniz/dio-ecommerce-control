package br.com.dio.warehouse.service;

import br.com.dio.warehouse.entity.ProductEntity;
import br.com.dio.warehouse.dto.ProductInfoDTO;

import java.util.List;
import java.util.UUID;

public interface IProductService {
    ProductEntity save(final ProductEntity entity );

    void changeActivated(final UUID id, final boolean active);

    List<ProductEntity> findAllActive();

    ProductInfoDTO findInfo(final UUID id);

    void purchase(final UUID id);
}
