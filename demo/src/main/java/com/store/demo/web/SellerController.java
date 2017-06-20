package com.store.demo.web;

import com.store.demo.domain.Seller;
import com.store.demo.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Alavi on 18-06-17.
 */
@RestController
@RequestMapping("/sellers")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Seller> getAllSellers()
    {
        return  sellerService.getAllSellers();
    }


    @RequestMapping(method = RequestMethod.POST)
    public void addSeller(@RequestBody SellerController.SellerRequestDTO sellerRequestDTO)
    {
        sellerService.addSeller(sellerRequestDTO);
    }


    @RequestMapping(value = "/{sellerId}",method = RequestMethod.DELETE)
    public ResponseEntity deleteCar(@PathVariable long sellerId){
        sellerService.deleteSellerId(sellerId);
        return  new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = "/{sellerId}",method = RequestMethod.PUT)
    public ResponseEntity updateSeller(@PathVariable long sellerId,@RequestBody SellerController.SellerRequestDTO sellerRequestDTO){
        sellerService.updateSeller(sellerId,sellerRequestDTO);
        return  new ResponseEntity(HttpStatus.OK);
    }

    public  static class SellerRequestDTO {

        private  String  name;
        private   int age;
        private int ci;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getCi() {
            return ci;
        }

        public void setCi(int ci) {
            this.ci = ci;
        }
    }
}
