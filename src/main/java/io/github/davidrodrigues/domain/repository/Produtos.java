package io.github.davidrodrigues.domain.repository;

import io.github.davidrodrigues.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {
}
