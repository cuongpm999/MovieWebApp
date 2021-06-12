package vn.PTIT.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "poster_video_phim")
public class PosterVideoPhim extends BaseEntity {
	@Column(name = "id_google_drive", length = 2000, nullable = false)
	private String id_google_drive;

	@Column(name = "status", nullable = true)
	private Boolean status;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "phim_id")
	private Phim phim;

	public String getId_google_drive() {
		return id_google_drive;
	}

	public void setId_google_drive(String id_google_drive) {
		this.id_google_drive = id_google_drive;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Phim getPhim() {
		return phim;
	}

	public void setPhim(Phim phim) {
		this.phim = phim;
	}

}
