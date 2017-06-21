package com.abedoya.finalTest.service;

import com.abedoya.finalTest.domain.RegistryCarSold;
import com.abedoya.finalTest.domain.Seller;
import com.abedoya.finalTest.repository.SellerRepository;
import com.abedoya.finalTest.web.SellerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Punkerman on 6/20/2017.
 */
@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private RegistryCarSoldService registryCarSoldService;

    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    public void addSeller(SellerController.SellerRequestDTO sellerDTO) {
        Seller seller = new Seller();
        seller.setNumberCarsSold(sellerDTO.getNumberCarsSold());
        seller.setCi(sellerDTO.getCi());
        seller.setName(sellerDTO.getName());
        seller.setAge(sellerDTO.getAge());

        sellerRepository.save(seller);
    }

    public void updateSeller(Long id, SellerController.SellerRequestDTO sellerDTO) {

        Seller seller = sellerRepository.findOne(id);
        if (null != sellerDTO.getName()) {seller.setName(sellerDTO.getName());}
        if (null != sellerDTO.getAge()) {seller.setAge(sellerDTO.getAge());}
        if (null != sellerDTO.getCi()) {seller.setCi(sellerDTO.getCi());}
        if (null != sellerDTO.getNumberCarsSold()) {seller.setNumberCarsSold(sellerDTO.getNumberCarsSold());}

        sellerRepository.save(seller);
    }

    public void deleteSeller(Long id) {

        List<RegistryCarSold> registryCarSoldList = registryCarSoldService.getAllRegistryCarSolds();

        for (RegistryCarSold registryCarSold : registryCarSoldList) {
            Seller seller = registryCarSold.getSeller();
            if (seller.getId() == id) {
                registryCarSoldService.deleteRegistryCarSold(registryCarSold.getId());
            }
        }

        sellerRepository.delete(id);
    }
}
