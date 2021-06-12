package vn.PTIT.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.PTIT.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>{

}
