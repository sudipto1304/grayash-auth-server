package com.grayash.security.repository;


import com.grayash.security.entity.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<AuthEntity, String> {

    AuthEntity findByCustomerId(String customerId);

}
