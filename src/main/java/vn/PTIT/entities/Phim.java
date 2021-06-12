package vn.PTIT.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "phim")
public class Phim extends BaseEntity {
	@Column(name = "ten_phim_tiengviet", length = 2000, nullable = false)
	private String ten_phim_tiengviet;
	
	@Column(name = "ten_phim_tienganh", length = 2000, nullable = false)
	private String ten_phim_tienganh;
	
	@Column(name = "diem_IMDb", nullable = false)
	private double diem_IMDb;
	
	@Column(name = "dao_dien", length = 2000, nullable = false)
	private String dao_dien;
	
	@Column(name = "quoc_gia", length = 2000, nullable = false)
	private String quoc_gia;
	
	@Column(name = "nam", nullable = false)
	private Integer nam;
	
	@Column(name = "thoi_luong", length = 100, nullable = false)
	private String thoi_luong;
	
	@Column(name = "so_tap", length = 100, nullable = false)
	private String so_tap;
	
	@Column(name = "chat_luong", length = 100, nullable = false)
	private String chat_luong;
	
	@Column(name = "the_loai", length = 2000, nullable = false)
	private String the_loai;
	
	@Column(name = "noi_dung_phim", nullable = false, columnDefinition = "text")
	private String noi_dung_phim;
	
	@Column(name = "congty_sx", length = 2000, nullable = false)
	private String congty_sx;
	
	@Column(name = "trailer", length = 2000, nullable = false)
	private String trailer;
	
	@Column(name = "imdb", nullable = true)
	private Boolean imdb;
	
	@Column(name = "luot_xem", nullable = true)
	private Integer luot_xem;
	
	@Column(name = "seo", length = 1000, nullable = false)
	private String seo;
	
	@Column(name = "status", nullable = true)
	private Boolean status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "hinhthuc_id")
	private HinhThuc hinhThuc;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "phim", fetch = FetchType.LAZY)
	private List<PosterVideoPhim> posterVideoPhims = new ArrayList<PosterVideoPhim>();

	public void addPosterPhim(PosterVideoPhim posterVideoPhim) {
		posterVideoPhims.add(posterVideoPhim);
		posterVideoPhim.setPhim(this);
	}

	public void removePosterPhim(PosterVideoPhim posterVideoPhim) {
		posterVideoPhims.remove(posterVideoPhim);
		posterVideoPhim.setPhim(null);
	}
	
	public String getTen_phim_tiengviet() {
		return ten_phim_tiengviet;
	}

	public void setTen_phim_tiengviet(String ten_phim_tiengviet) {
		this.ten_phim_tiengviet = ten_phim_tiengviet;
	}

	public String getTen_phim_tienganh() {
		return ten_phim_tienganh;
	}

	public void setTen_phim_tienganh(String ten_phim_tienganh) {
		this.ten_phim_tienganh = ten_phim_tienganh;
	}

	public double getDiem_IMDb() {
		return diem_IMDb;
	}

	public void setDiem_IMDb(double diem_IMDb) {
		this.diem_IMDb = diem_IMDb;
	}

	public String getDao_dien() {
		return dao_dien;
	}

	public void setDao_dien(String dao_dien) {
		this.dao_dien = dao_dien;
	}

	public String getQuoc_gia() {
		return quoc_gia;
	}

	public void setQuoc_gia(String quoc_gia) {
		this.quoc_gia = quoc_gia;
	}

	public Integer getNam() {
		return nam;
	}

	public void setNam(Integer nam) {
		this.nam = nam;
	}

	public String getThoi_luong() {
		return thoi_luong;
	}

	public void setThoi_luong(String thoi_luong) {
		this.thoi_luong = thoi_luong;
	}

	public String getSo_tap() {
		return so_tap;
	}

	public void setSo_tap(String so_tap) {
		this.so_tap = so_tap;
	}

	public String getChat_luong() {
		return chat_luong;
	}

	public void setChat_luong(String chat_luong) {
		this.chat_luong = chat_luong;
	}

	public String getThe_loai() {
		return the_loai;
	}

	public void setThe_loai(String the_loai) {
		this.the_loai = the_loai;
	}

	public String getNoi_dung_phim() {
		return noi_dung_phim;
	}

	public void setNoi_dung_phim(String noi_dung_phim) {
		this.noi_dung_phim = noi_dung_phim;
	}

	public String getCongty_sx() {
		return congty_sx;
	}

	public void setCongty_sx(String congty_sx) {
		this.congty_sx = congty_sx;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Boolean getImdb() {
		return imdb;
	}

	public void setImdb(Boolean imdb) {
		this.imdb = imdb;
	}

	public HinhThuc getHinhThuc() {
		return hinhThuc;
	}

	public void setHinhThuc(HinhThuc hinhThuc) {
		this.hinhThuc = hinhThuc;
	}

	public List<PosterVideoPhim> getPosterVideoPhims() {
		return posterVideoPhims;
	}

	public void setPosterVideoPhims(List<PosterVideoPhim> posterVideoPhims) {
		this.posterVideoPhims = posterVideoPhims;
	}

	public Integer getLuot_xem() {
		return luot_xem;
	}

	public void setLuot_xem(Integer luot_xem) {
		this.luot_xem = luot_xem;
	}
	
}
