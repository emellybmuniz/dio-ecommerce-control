package br.com.dio.warehouse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductDetailDTO(
    @JsonProperty("id")
    UUID id,
    @JsonProperty("name")
    String name,
    @JsonProperty("price")
    BigDecimal price) {
}
