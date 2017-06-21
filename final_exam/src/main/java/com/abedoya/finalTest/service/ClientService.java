package com.abedoya.finalTest.service;

import com.abedoya.finalTest.domain.Client;
import com.abedoya.finalTest.domain.RegistryCarSold;
import com.abedoya.finalTest.repository.ClientRepository;
import com.abedoya.finalTest.web.ClientController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Punkerman on 6/20/2017.
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RegistryCarSoldService registryCarSoldService;

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public void addClient(ClientController.ClientRequestDTO clientDTO) {
        Client client = new Client();
        client.setCi(clientDTO.getCi());
        client.setName(clientDTO.getName());
        client.setCelphone(clientDTO.getCel());
        client.setProfession(clientDTO.getProfession());

        clientRepository.save(client);
    }

    public void updateClient(Long id, ClientController.ClientRequestDTO clientDTO) {

        Client client = clientRepository.findOne(id);
        if (null != clientDTO.getCi()) {client.setCi(clientDTO.getCi());}
        if (null != clientDTO.getName()) {client.setName(clientDTO.getName());}
        if (null != clientDTO.getCel()) {client.setCelphone(clientDTO.getCel());}
        if (null != clientDTO.getProfession()) {client.setProfession(clientDTO.getProfession());}

        clientRepository.save(client);
    }

    public void deleteClient(Long id) {

        List<RegistryCarSold> registryCarSoldList = registryCarSoldService.getAllRegistryCarSolds();

        for (RegistryCarSold registryCarSold : registryCarSoldList) {
            Client client = registryCarSold.getClient();
            if (client.getId() == id) {
                registryCarSoldService.deleteRegistryCarSold(registryCarSold.getId());
            }
        }

        clientRepository.delete(id);
    }
}
