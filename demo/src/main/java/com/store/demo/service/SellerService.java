package com.store.demo.service;

import com.store.demo.domain.Car;
import com.store.demo.domain.Seller;
import com.store.demo.repository.SellerRepository;
import com.store.demo.web.SellerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alavi on 18-06-17.
 */
@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;


    public List<Seller> getAllSellers() {
     return    sellerRepository.findAll();
    }
    public void addSeller(SellerController.SellerRequestDTO sellerRequestDTO) {
        Seller newseller= new Seller();
        newseller.setAge(sellerRequestDTO.getAge());
        newseller.setCi(sellerRequestDTO.getCi());
        newseller.setName(sellerRequestDTO.getName());

        sellerRepository.save(newseller);
    }

    public void deleteSellerId(long sellerId) {
        sellerRepository.delete(sellerId);
    }

    public void updateSeller(long sellerId, SellerController.SellerRequestDTO sellerRequestDTO) {
        Seller actualizar = sellerRepository.findOne(sellerId);
        actualizar.setName(sellerRequestDTO.getName());
        actualizar.setCi(sellerRequestDTO.getCi());
        actualizar.setAge(sellerRequestDTO.getAge());

        sellerRepository.save(actualizar);
    }


}
