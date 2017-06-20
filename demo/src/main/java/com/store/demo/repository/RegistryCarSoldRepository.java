package com.store.demo.repository;

import com.store.demo.domain.RegistryCarSold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Alavi on 18-06-17.
 */
public interface RegistryCarSoldRepository  extends JpaRepository<RegistryCarSold,Long>{


}
