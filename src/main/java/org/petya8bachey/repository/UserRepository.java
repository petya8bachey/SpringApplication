package org.petya8bachey.repository;

import org.petya8bachey.domain.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository @Transactional
public interface UserRepository extends JpaRepository<MyUser, Integer> {
    MyUser findByUsername(String username);
}
