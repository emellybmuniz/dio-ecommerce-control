package br.com.dio.warehouse.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "storefront.rabbitmq.queue")
public class RabbitmqQueueProperties {

    private String productChangeAvailability;
    private Warehouse warehouse = new Warehouse();

    @Data
    public static class Warehouse {
        private String basePath;
    }
}
