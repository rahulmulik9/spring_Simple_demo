package com.rahul.microservices.user.databaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

}
