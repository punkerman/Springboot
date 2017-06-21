package com.abedoya.finalTest.web;

import com.abedoya.finalTest.domain.Car;
import com.abedoya.finalTest.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Punkerman on 6/20/2017.
 */
@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addCar(@RequestBody CarRequestDTO carDTO) {
        carService.addCar(carDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable Long id, @RequestBody CarRequestDTO carDTO) {
        carService.updateCar(id, carDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    public static class CarRequestDTO {

        private String brand;

        private Integer year;

        private String model;

        private String color;

        private String image;

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public Integer getYear() {
            return year;
        }

        public void setYear(Integer year) {
            this.year = year;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
