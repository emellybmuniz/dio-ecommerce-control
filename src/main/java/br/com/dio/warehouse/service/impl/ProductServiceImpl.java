package br.com.dio.warehouse.service.impl;

import br.com.dio.warehouse.dto.ProductDetailDTO;
import br.com.dio.warehouse.entity.ProductEntity;
import br.com.dio.warehouse.dto.ProductInfoDTO;
import br.com.dio.warehouse.mapper.IProductMapper;
import br.com.dio.warehouse.repository.ProductRepository;
import br.com.dio.warehouse.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements IProductService {
    private final ProductRepository repository;
    private final RestTemplate warehouseClient;
    private final IProductMapper mapper;

    @Override
    public ProductEntity save(final ProductEntity entity) {
        return repository.save(entity);
    }

    @Override
    public void changeActivated(final UUID id, final boolean active) {
        Optional<ProductEntity> opt = repository.findById(id);

        opt.ifPresent(entity -> {
            entity.setActive(active);
            repository.save(entity);
        });
    }

    @Override
    public List<ProductEntity> findAllActive() {
        return repository.findByActiveTrueOrderByNameAsc();
    }

    @Override
    public ProductInfoDTO findInfo(final UUID id) {
        ProductEntity entity = findById(id);
        var price = requestCurrentAmount(id);
        return mapper.toDTO(entity, price);
    }

    @Override
    public void purchase(final UUID id) {
        purchaseWarehouse(id);
    }

    private ProductEntity findById(final UUID id) {
        return repository.findById(id).orElseThrow();
    }

    private BigDecimal requestCurrentAmount(final UUID id) {
        ProductDetailDTO dto = warehouseClient.getForObject("/products/{id}", ProductDetailDTO.class, id);
        if (dto == null || dto.price() == null) {
            return BigDecimal.ZERO;
        }
        return dto.price();
    }

    private void purchaseWarehouse(final UUID id) {
        var path = String.forma("/products/%s/purchase", id);
        warehouseClient.post()
                .uri(path)
                .retrieve()
                .toBodilessEntity();
    }

}
