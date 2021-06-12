package vn.PTIT.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hinh_thuc")
public class HinhThuc extends BaseEntity {
	@Column(name = "ten_loai", length = 100, nullable = false)
	private String ten_loai;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "hinhThuc", fetch = FetchType.LAZY)
	private List<Phim> phims = new ArrayList<Phim>();
	
	public void addPhim(Phim phim) {
		phims.add(phim);
		phim.setHinhThuc(this);
	}
	
	public void removePhim(Phim phim) {
		phims.remove(phim);
		phim.setHinhThuc(null);
	}

	public String getTen_loai() {
		return ten_loai;
	}

	public void setTen_loai(String ten_loai) {
		this.ten_loai = ten_loai;
	}

	public List<Phim> getPhims() {
		return phims;
	}

	public void setPhims(List<Phim> phims) {
		this.phims = phims;
	}

}
