package br.com.dio.warehouse.controller;

import br.com.dio.warehouse.controller.request.ProductSaveRequest;
import br.com.dio.warehouse.controller.response.ProductAvailableResponse;
import br.com.dio.warehouse.controller.response.ProductDetailResponse;
import br.com.dio.warehouse.controller.response.ProductSavedResponse;
import br.com.dio.warehouse.mapper.IProductMapper;
import br.com.dio.warehouse.service.IProductService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
@Log4j2

public class ProductController {
    private final IProductService service;
    private final IProductMapper mapper;

    @PostMapping
    @ResponseStatus(CREATED)
    ProductSavedResponse create(@RequestBody final ProductSaveRequest request){
        var entity = mapper.toEntity(request);
        entity = service.save(entity);
        return mapper.toResponse(entity);
    }

    @PostMapping("{id}/purchase")
    @ResponseStatus(NO_CONTENT)
    void purchase(@PathVariable final UUID id){
        service.purchase(id);
    }

    @GetMapping
    List<ProductAvailableResponse> listAvailable(){
        var entities = service.findAllActive();
        return mapper.toResponse(entities);
    }

    @GetMapping("{id}")
    ProductDetailResponse findById(@PathVariable final UUID id){
        var dto = service.findInfo(id);
        return mapper.toResponse(dto);
    }
}
