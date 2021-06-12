package vn.PTIT.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vn.PTIT.entities.Phim;

@Repository
public interface PhimRepository extends JpaRepository<Phim, Integer> {
	@Query("select p from Phim p where p.status=true and p.hinhThuc.id = ?1")
	List<Phim> findHotMovie(Integer hinhthuc_id);
}
