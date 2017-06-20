package com.store.demo.repository;

import com.store.demo.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Alavi on 18-06-17.
 */
public interface CarRepository extends JpaRepository<Car,Long>{
}
