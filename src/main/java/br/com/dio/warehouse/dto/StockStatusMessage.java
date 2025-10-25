package br.com.dio.warehouse.dto;

import java.util.UUID;

public record StockStatusMessage(UUID id, String status) {

    public boolean active() {return status.equals("AVAILABLE");}
}
