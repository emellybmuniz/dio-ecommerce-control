package br.com.dio.warehouse.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record ProductSavedResponse (
    @JsonProperty("id")
    UUID id,
    @JsonProperty("name")
    String name,
    @JsonProperty("active")
    Boolean active){
}
