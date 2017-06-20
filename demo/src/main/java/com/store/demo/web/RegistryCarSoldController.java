package com.store.demo.web;


import com.store.demo.domain.RegistryCarSold;
import com.store.demo.service.RegistryCarSoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Alavi on 18-06-17.
 */
@RestController
@RequestMapping("/registrycarsolds")
public class RegistryCarSoldController {

    @Autowired
    private RegistryCarSoldService registryCarSoldService;



    @RequestMapping(method = RequestMethod.GET)
    public List<RegistryCarSold> getAllRegistryCarSolds()
    {
        return  registryCarSoldService.getAllRegistryCarSolds();
    }


    @RequestMapping(method = RequestMethod.POST)
    public void addCar(@RequestBody RegistryCarSoldController.RegistryCarSoldRequestDTO registryCarSoldRequestDTO)
    {
        registryCarSoldService.addRegistryCarSold(registryCarSoldRequestDTO);
    }


    @RequestMapping(value = "/{rcarsolId}",method = RequestMethod.DELETE)
    public ResponseEntity deleteRegistryCarSold(@PathVariable long rcarsolId){
        registryCarSoldService.deleteRegistryCarSoldId(rcarsolId);
        return  new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = "/{rcarsolId}",method = RequestMethod.PUT)
    public ResponseEntity updateCar(@PathVariable long registryCarSoldId,@RequestBody RegistryCarSoldController.RegistryCarSoldRequestDTO registryCarSoldRequestDTO){
        registryCarSoldService.updateRegistryCarSold(registryCarSoldId,registryCarSoldRequestDTO);
        return  new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public HashMap canCarsSoldBySeller(@PathVariable long id){
       return registryCarSoldService.canCarSoldBySelle(id);


    }



    public static  class RegistryCarSoldRequestDTO {
        private long buyer;
        private long car;
        private long seller;
        private Date dateofsell;

        public long getBuyer() {
            return buyer;
        }

        public void setBuyer(long buyer) {
            this.buyer = buyer;
        }

        public long getCar() {
            return car;
        }

        public void setCar(long car) {
            this.car = car;
        }

        public long getSeller() {
            return seller;
        }

        public void setSeller(long seller) {
            this.seller = seller;
        }

        public Date getDateofsell() {
            return dateofsell;
        }

        public void setDateofsell(Date dateofsell) {
            this.dateofsell = dateofsell;
        }
    }
}
