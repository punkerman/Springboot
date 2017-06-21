package com.abedoya.finalTest.web;

import com.abedoya.finalTest.domain.RegistryCarSold;
import com.abedoya.finalTest.domain.Seller;
import com.abedoya.finalTest.service.RegistryCarSoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Punkerman on 6/20/2017.
 */
@RestController
@RequestMapping("/registries")
public class RegistryCarSoldController {

    @Autowired
    private RegistryCarSoldService registryCarSoldService;

    @RequestMapping(method = RequestMethod.GET)
    public List<RegistryCarSold> getAllRegistryCarSolds() {
        return registryCarSoldService.getAllRegistryCarSolds();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addRegistryCarSold(RegistryCarSoldRequestDTO registryCarSoldDTO) {
        registryCarSoldService.addRegistryCarSold(registryCarSoldDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable Long id, @RequestBody RegistryCarSoldRequestDTO registryCarSoldDTO) {
        registryCarSoldService.updateRegistryCarSold(id, registryCarSoldDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable Long id) {
        registryCarSoldService.deleteRegistryCarSold(id);
    }

    @RequestMapping(value = "/canCarsSoldBySeller/{idSeller}", method = RequestMethod.GET)
    public Seller getSeller(@PathVariable Long idSeller) {
        return registryCarSoldService.getSeller(idSeller);
    }

    public static class RegistryCarSoldRequestDTO {

        private Long buyerId;

        private Long sellerId;

        public Long getBuyerId() {
            return buyerId;
        }

        public void setBuyerId(Long buyerId) {
            this.buyerId = buyerId;
        }

        public Long getSellerId() {
            return sellerId;
        }

        public void setSellerId(Long sellerId) {
            this.sellerId = sellerId;
        }
    }

}
