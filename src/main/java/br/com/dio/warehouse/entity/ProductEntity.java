package br.com.dio.warehouse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class ProductEntity {
    @Id
    private UUID id;
    private String name;
    private Boolean active;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(active, that.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, active);
    }
}

