package br.com.dio.warehouse.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record ProductAvailableResponse (
    @JsonProperty("id")
    UUID id,
    @JsonProperty("name")
    String name) {
}
