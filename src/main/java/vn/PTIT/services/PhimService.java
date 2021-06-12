package vn.PTIT.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.PTIT.entities.Phim;
import vn.PTIT.repositories.PhimRepository;

@Service
public class PhimService {
	@Autowired
	public PhimRepository phimRepository;
	@PersistenceContext
	EntityManager entityManager;

	private static int LIMIT = 27;

	@SuppressWarnings("unchecked")
	public List<Phim> search(Integer hinhThucId, Integer pageNumber) {

		String jpql = "select p from Phim p where p.status=true"; // JPQL: lấy tất cả Post trong db.
		if (hinhThucId != null) {
			jpql += " and p.hinhThuc.id=" + hinhThucId + " order by p.id desc"; // select p from Post p where 1=1 and
																				// p.category.id=1
		}
		Query query = entityManager.createQuery(jpql, Phim.class);
		query.setFirstResult((pageNumber - 1) * LIMIT);
		query.setMaxResults(LIMIT);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Phim> search1(Integer hinhThucId) {

		String jpql = "select p from Phim p where p.status=true"; // JPQL: lấy tất cả Post trong db.
		if (hinhThucId != null) {
			jpql += " and p.hinhThuc.id=" + hinhThucId + " order by p.id desc"; // select p from Post p where 1=1 and
																				// p.category.id=1
		}
		Query query = entityManager.createQuery(jpql, Phim.class);
		return query.getResultList();
	}

	public List<Phim> hotOddMovie() {
		List<Phim> listPhimHotOdd = phimRepository.findHotMovie(2);
		Collections.sort(listPhimHotOdd, new Comparator<Phim>() {

			@Override
			public int compare(Phim o1, Phim o2) {
				
				return o2.getLuot_xem()-o1.getLuot_xem();
			}
			
		});
		
		return listPhimHotOdd;
	}

	public List<Phim> hotSeriesMovie() {

		List<Phim> listPhimHotSeries= phimRepository.findHotMovie(1);
		Collections.sort(listPhimHotSeries, new Comparator<Phim>() {

			@Override
			public int compare(Phim o1, Phim o2) {
				
				return o2.getLuot_xem()-o1.getLuot_xem();
			}
			
		});
		
		return listPhimHotSeries;
	}

	@SuppressWarnings("unchecked")
	public List<Phim> imdbMovie(Integer hinhThucId) {

		String jpql = "select p from Phim p where p.status=true"; // JPQL: lấy tất cả Post trong db.
		if (hinhThucId != null) {
			jpql += " and p.hinhThuc.id=" + hinhThucId + " and p.imdb=true";
		}
		Query query = entityManager.createQuery(jpql, Phim.class);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Phim> cartoonMovie() {

		String jpql = "select p from Phim p where p.status=true and p.the_loai like '%Phim hoạt hình%'"; // JPQL: lấy tất cả Post
																								// trong db.
		Query query = entityManager.createQuery(jpql, Phim.class);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Phim> searchName(String tenPhim) {

		if (!tenPhim.isEmpty() && !tenPhim.equalsIgnoreCase("'")) {
			String jpql = "select p from Phim p where p.status=true and lower(p.ten_phim_tiengviet) like" + "'%" + tenPhim.toLowerCase() + "%'" + " or lower(p.ten_phim_tienganh) like" + "'%"
					+ tenPhim.toLowerCase() + "%'";
			Query query = entityManager.createQuery(jpql, Phim.class);
			return query.getResultList();
		}
		
		return null;
		
	}

	@SuppressWarnings("unchecked")
	public List<Phim> searchTheLoai(String theloai, Integer pageNumber) {

		String jpql = "select p from Phim p where p.status=true"; // JPQL: lấy tất cả Post trong db.
		if (theloai != null) {
			jpql += " and p.the_loai like" + "'%" + theloai + "%'";
		}
		Query query = entityManager.createQuery(jpql, Phim.class);

		query.setFirstResult((pageNumber - 1) * LIMIT);
		query.setMaxResults(LIMIT);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Phim> searchNam(Integer nam, Integer pageNumber) {

		String jpql = "select p from Phim p where p.status=true"; // JPQL: lấy tất cả Post trong db.
		if (nam != null) {
			jpql += " and p.nam=" + nam;
		}
		Query query = entityManager.createQuery(jpql, Phim.class);

		query.setFirstResult((pageNumber - 1) * LIMIT);
		query.setMaxResults(LIMIT);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Phim> searchTruocNam(Integer nam, Integer pageNumber) {

		String jpql = "select p from Phim p where p.status=true"; // JPQL: lấy tất cả Post trong db.
		if (nam != null) {
			jpql += " and p.nam<" + nam;
		}
		Query query = entityManager.createQuery(jpql, Phim.class);

		query.setFirstResult((pageNumber - 1) * LIMIT);
		query.setMaxResults(LIMIT);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Phim> searchMovieBySeo(String seo) {

		String jpql = "select p from Phim p where p.status=true and"; // JPQL: lấy tất cả Post trong db.
		if (seo != null) {
			jpql += " p.seo = '" + seo +"'"; // select p from Post p where 1=1 and
																				// p.category.id=1
		}
		Query query = entityManager.createQuery(jpql, Phim.class);
		return query.getResultList();
	}

}
