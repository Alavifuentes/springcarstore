package com.store.demo.web;

import com.store.demo.domain.Buyer;
import com.store.demo.service.BuyerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Alavi on 18-06-17.
 */
@RestController
@RequestMapping("/buyers")
@Api(value="onlinestore", description="Register of buyer")
public class BuyerController {

@Autowired
private BuyerService buyerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Buyer> getAllUsers()
    {
        return  buyerService.getAllBuyer();
    }


    @RequestMapping(method = RequestMethod.POST)
    public void addBuyer(@RequestBody BuyerRequestDTO buyer)
    {
        buyerService.addBuyer(buyer);
    }


    @RequestMapping(value = "/{buyerId}",method = RequestMethod.DELETE)
    public ResponseEntity deleteBuyer(@PathVariable long buyerId){
        buyerService.deleteBuyerId(buyerId);
        return  new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = "/{buyerId}",method = RequestMethod.PUT)
    public ResponseEntity updateCar(@PathVariable long buyerId,@RequestBody BuyerRequestDTO buyerRequestDTO){
        buyerService.updateBuyer(buyerId,buyerRequestDTO);
        return  new ResponseEntity(HttpStatus.OK);
    }

    public static  class BuyerRequestDTO {
        private String name;
        private int ci;
        private String profession;
        private int cel;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCi() {
            return ci;
        }

        public void setCi(int ci) {
            this.ci = ci;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public int getCel() {
            return cel;
        }

        public void setCel(int cel) {
            this.cel = cel;
        }
    }
}
