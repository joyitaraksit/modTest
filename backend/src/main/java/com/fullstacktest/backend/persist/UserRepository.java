package com.fullstacktest.backend.persist;

import com.fullstacktest.backend.model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserRegistration, Long> {
}
