package com.abedoya.finalTest.service;

import com.abedoya.finalTest.domain.Client;
import com.abedoya.finalTest.domain.RegistryCarSold;
import com.abedoya.finalTest.domain.Seller;
import com.abedoya.finalTest.repository.ClientRepository;
import com.abedoya.finalTest.repository.RegistryCarSoldRepository;
import com.abedoya.finalTest.repository.SellerRepository;
import com.abedoya.finalTest.web.RegistryCarSoldController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Punkerman on 6/20/2017.
 */
@Service
public class RegistryCarSoldService {
    @Autowired
    private RegistryCarSoldRepository registryCarSoldRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private SellerService sellerService;

    public List<RegistryCarSold> getAllRegistryCarSolds(){
        return registryCarSoldRepository.findAll();
    }

    public void addRegistryCarSold(RegistryCarSoldController.RegistryCarSoldRequestDTO registryCarSoldDTO) {
        Client client = clientRepository.findOne(registryCarSoldDTO.getBuyerId());

        Seller seller = sellerRepository.findOne(registryCarSoldDTO.getSellerId());
        seller.setNumberCarsSold(seller.getNumberCarsSold()+1);

        RegistryCarSold registryCarSold = new RegistryCarSold();
        registryCarSold.setClient(client);
        registryCarSold.setSeller(seller);

        registryCarSoldRepository.save(registryCarSold);
    }

    public void updateRegistryCarSold(Long id, RegistryCarSoldController.RegistryCarSoldRequestDTO registryCarSoldDTO) {
        Client client = clientRepository.findOne(registryCarSoldDTO.getBuyerId());

        Seller seller = sellerRepository.findOne(registryCarSoldDTO.getSellerId());

        RegistryCarSold registryCarSold = registryCarSoldRepository.findOne(id);
        if (null != registryCarSoldDTO.getBuyerId()) {registryCarSold.setClient(client);}
        if (null != registryCarSoldDTO.getSellerId()) {registryCarSold.setSeller(seller);}

        registryCarSoldRepository.save(registryCarSold);
    }

    public void deleteRegistryCarSold(Long id) {
        registryCarSoldRepository.delete(id);
    }

    public Seller getSeller(Long id) {
        return sellerRepository.findOne(id);
    }
}
