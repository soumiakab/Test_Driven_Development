package com.test_driven_development.repository;

import com.test_driven_development.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepositoryI extends CrudRepository<Client,Long> {

}
