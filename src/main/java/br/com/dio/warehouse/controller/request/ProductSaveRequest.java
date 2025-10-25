package br.com.dio.warehouse.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class ProductSaveRequest {
    @JsonProperty("id")
    UUID uuid;
    @JsonProperty("name")
    String name;
}
