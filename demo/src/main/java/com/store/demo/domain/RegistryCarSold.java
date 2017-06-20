package com.store.demo.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Alavi on 18-06-17.
 * Carro de registro de carro vendido
 */
@Entity
@Table(name = "RegistryCarSolds")
public class RegistryCarSold {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    /**
     * fecha de ventas
     */
    @ManyToOne
    private Buyer buyer;
    @ManyToOne
    private Car car;
    @ManyToOne
    private Seller seller;


    private Date dateofsell;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Date getDateofsell() {
        return dateofsell;
    }

    public void setDateofsell(Date dateofsell) {
        this.dateofsell = dateofsell;
    }
}
