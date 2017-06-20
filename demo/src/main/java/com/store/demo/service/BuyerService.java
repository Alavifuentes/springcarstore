package com.store.demo.service;

import com.store.demo.domain.Buyer;
import com.store.demo.repository.BuyerRepository;
import com.store.demo.web.BuyerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alavi on 18-06-17.
 */
@Service
public class BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;

    public List<Buyer>  getAllBuyer()
    {
    return     buyerRepository.findAll();
    }

    /**
     * añadir el buyer
     */
    public void addBuyer(BuyerController.BuyerRequestDTO buyer)
    {
        Buyer newbuyer= new Buyer();
        newbuyer.setCel(buyer.getCel());
        newbuyer.setCi(buyer.getCi());
        newbuyer.setName(buyer.getName());
        newbuyer.setProfession(buyer.getProfession());
        buyerRepository.save(newbuyer);

    }

    /**
     * eliminar el buyer
     * @param buyerId
     */
    public void deleteBuyerId(long buyerId) {
        buyerRepository.delete(buyerId);

    }

    /**
     * actualizar el buyer
     * @param buyerId
     * @param buyerRequestDTO
     */
    public void updateBuyer(long buyerId, BuyerController.BuyerRequestDTO buyerRequestDTO) {
        Buyer actualizar  = buyerRepository.findOne(buyerId);
        actualizar.setName(buyerRequestDTO.getName());
        actualizar.setProfession(buyerRequestDTO.getProfession());
        actualizar.setCi(buyerRequestDTO.getCi());
        actualizar.setCel(buyerRequestDTO.getCel());

        buyerRepository.save(actualizar);
    }
}
