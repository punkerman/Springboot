package com.abedoya.finalTest.web;

import com.abedoya.finalTest.domain.Client;
import com.abedoya.finalTest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Punkerman on 6/20/2017.
 */
@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Client> getAllBuyers() {
        return clientService.getClients();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addCar(@RequestBody ClientRequestDTO clientDTO) {
        clientService.addClient(clientDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable Long id, @RequestBody ClientRequestDTO clientDTO) {
        clientService.updateClient(id, clientDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBuyer(@PathVariable Long id) {
        clientService.deleteClient(id);
    }


    public static class ClientRequestDTO {

        private String name;
        private Integer ci;
        private String profession;
        private Integer cel;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getCi() {
            return ci;
        }

        public void setCi(Integer ci) {
            this.ci = ci;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public Integer getCel() {
            return cel;
        }

        public void setCel(Integer cel) {
            this.cel = cel;
        }
    }
}
