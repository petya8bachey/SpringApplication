package org.petya8bachey.repository;

import org.petya8bachey.domain.MyRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository @Transactional
public interface RoleRepository extends JpaRepository<MyRole, Integer> {

}
