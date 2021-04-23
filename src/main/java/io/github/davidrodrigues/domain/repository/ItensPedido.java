package io.github.davidrodrigues.domain.repository;

import io.github.davidrodrigues.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedido extends JpaRepository<ItemPedido, Integer> {
}
