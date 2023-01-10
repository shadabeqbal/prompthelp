package com.project.one.repository;

import com.project.one.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,String> {

    @Query("from Client c where c.email = :email")
    Client userEmailExists(String email);

    @Query("from Client c where c.mobile = :mobile")
    Client userMobileExists(String mobile);
}
