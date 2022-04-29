package com.ibm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByLoginID(String loginID);
}
