package com.store.demo.repository;

import com.store.demo.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alavi on 18-06-17.
 */
public interface SellerRepository  extends JpaRepository<Seller,Long> {
}
