package com.vcabading.projectmanager.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vcabading.projectmanager.models.User;

/////////////////////////////////////////////////////////////
//	USER REPOSITORY
/////////////////////////////////////////////////////////////

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
    
}
