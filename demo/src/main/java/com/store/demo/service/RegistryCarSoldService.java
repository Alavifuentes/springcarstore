package com.store.demo.service;

import com.store.demo.domain.Buyer;
import com.store.demo.domain.Car;
import com.store.demo.domain.RegistryCarSold;
import com.store.demo.domain.Seller;
import com.store.demo.repository.BuyerRepository;
import com.store.demo.repository.CarRepository;
import com.store.demo.repository.RegistryCarSoldRepository;
import com.store.demo.repository.SellerRepository;
import com.store.demo.web.RegistryCarSoldController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Alavi on 18-06-17.
 */
@Service
public class RegistryCarSoldService {

    @Autowired
    private RegistryCarSoldRepository registryCarSoldRepository;
    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private SellerRepository sellerRepository;


    public void addRegistryCarSold(RegistryCarSoldController.RegistryCarSoldRequestDTO registryCarSoldRequestDTO) {
        RegistryCarSold newRCardSold= new RegistryCarSold();

        Buyer  buyer= buyerRepository.findOne(registryCarSoldRequestDTO.getBuyer());

        Car car = carRepository.findOne(registryCarSoldRequestDTO.getCar());

        Seller seller= sellerRepository.findOne(registryCarSoldRequestDTO.getSeller());

        newRCardSold.setBuyer(buyer);
        newRCardSold.setCar(car);
        newRCardSold.setSeller(seller);

        registryCarSoldRepository.save(newRCardSold);

    }

    public void deleteRegistryCarSoldId(long rcasolId) {
        registryCarSoldRepository.delete(rcasolId);
    }

    public void updateRegistryCarSold(long registryCarSoldId, RegistryCarSoldController.RegistryCarSoldRequestDTO registryCarSoldRequestDTO) {

        RegistryCarSold  registryCarSold  = registryCarSoldRepository.findOne(registryCarSoldId);

        Buyer buyer = buyerRepository.findOne(registryCarSoldRequestDTO.getBuyer());
        Car car = carRepository.findOne(registryCarSoldRequestDTO.getCar());
        Seller seller = sellerRepository.findOne(registryCarSoldRequestDTO.getSeller());

        registryCarSold.setSeller(seller);
        registryCarSold.setCar(car);
        registryCarSold.setBuyer(buyer);

        registryCarSoldRepository.save(registryCarSold);


    }

    public List<RegistryCarSold> getAllRegistryCarSolds() {
        return  registryCarSoldRepository.findAll();
    }

    public HashMap canCarSoldBySelle(long id) {
        HashMap lista= new HashMap();
        Seller   seller= sellerRepository.findOne(id);

           lista.put("nameSeller",seller.getName());
            lista.put("QuatityCarsSold",getSellerCount(id));
          return lista;
    }

    private int getSellerCount(long id) {

        int res=0;

        List<RegistryCarSold> lista= registryCarSoldRepository.findAll();

        for (RegistryCarSold re: lista
             ) {

            if(re.getId()==id)
            {
                res=res+1;
            }


        }
        return   res;

    }
}
