package com.abedoya.finalTest.repository;

import com.abedoya.finalTest.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Punkerman on 6/20/2017.
 */
public interface ClientRepository extends JpaRepository<Client,Long> {
}
