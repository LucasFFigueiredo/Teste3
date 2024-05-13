package figueiredo.lucas.springboot2.repository;

import figueiredo.lucas.springboot2.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByName(String name);
}
