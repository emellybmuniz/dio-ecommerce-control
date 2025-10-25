package br.com.dio.warehouse.service;

import br.com.dio.warehouse.dto.StockStatusMessage;

public interface IProductChangeAvailabilityConsumer {
    void receive(final StockStatusMessage message);
}
