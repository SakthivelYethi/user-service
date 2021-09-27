package com.sakthi.service.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sakthi.service.user.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
