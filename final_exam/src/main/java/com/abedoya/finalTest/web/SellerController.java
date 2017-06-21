package com.abedoya.finalTest.web;


import com.abedoya.finalTest.domain.Seller;
import com.abedoya.finalTest.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Punkerman on 6/20/2017.
 */
@RestController
@RequestMapping("/sellers")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Seller> getAllCars() {
        return sellerService.getAllSellers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addCar(@RequestBody SellerRequestDTO sellerDTO) {
        sellerService.addSeller(sellerDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable Long id, @RequestBody SellerRequestDTO sellerDTO) {
        sellerService.updateSeller(id, sellerDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSeller(@PathVariable Long id) {
        sellerService.deleteSeller(id);
    }

    public static class SellerRequestDTO {

        private String name;

        private Integer age;

        private Integer ci;

        private Integer numberCarsSold;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getCi() {
            return ci;
        }

        public void setCi(Integer ci) {
            this.ci = ci;
        }

        public Integer getNumberCarsSold() {
            return numberCarsSold;
        }

        public void setNumberCarsSold(Integer numberCarsSold) {
            this.numberCarsSold = numberCarsSold;
        }
    }
}
