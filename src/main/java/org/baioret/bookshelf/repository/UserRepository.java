package org.baioret.bookshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from users where email = :email", nativeQuery = true) // нативный sql запрос
    Optional<User> findByEmail(String email);

//    @Query(value = "select u from User u where u.email = :email") // язык запросов Jpa
//    User findByEmail(String email);

//    User findByEmail(String email); // спецификация Jpa
}
