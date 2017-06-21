package com.abedoya.finalTest.domain;

import javax.persistence.*;

/**
 * Created by Punkerman on 6/20/2017.
 */
@Entity
public class RegistryCarSold {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Seller seller;

    @ManyToOne
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }



}
