package vn.PTIT.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.PTIT.entities.HinhThuc;

@Repository
public interface HinhThucRepository extends JpaRepository<HinhThuc, Integer> { }


