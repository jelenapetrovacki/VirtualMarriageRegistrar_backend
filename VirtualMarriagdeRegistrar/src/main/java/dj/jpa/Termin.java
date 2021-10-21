package dj.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the termin database table.
 * 
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@NamedQuery(name="Termin.findAll", query="SELECT t FROM Termin t")
public class Termin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TERMIN_ID_GENERATOR", sequenceName="termin_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TERMIN_ID_GENERATOR")
	private Integer id;

	private String datum;

	private String maticar;

	private String opstina;

	private String vreme;

	//bi-directional many-to-one association to Zahtev
	@JsonIgnore
	@OneToMany(mappedBy="termin")
	private List<Zahtev> zahtevs;

	public Termin() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDatum() {
		return this.datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getMaticar() {
		return this.maticar;
	}

	public void setMaticar(String maticar) {
		this.maticar = maticar;
	}

	public String getOpstina() {
		return this.opstina;
	}

	public void setOpstina(String opstina) {
		this.opstina = opstina;
	}

	public String getVreme() {
		return this.vreme;
	}

	public void setVreme(String vreme) {
		this.vreme = vreme;
	}

	public List<Zahtev> getZahtevs() {
		return this.zahtevs;
	}

	public void setZahtevs(List<Zahtev> zahtevs) {
		this.zahtevs = zahtevs;
	}

	public Zahtev addZahtev(Zahtev zahtev) {
		getZahtevs().add(zahtev);
		zahtev.setTermin(this);

		return zahtev;
	}

	public Zahtev removeZahtev(Zahtev zahtev) {
		getZahtevs().remove(zahtev);
		zahtev.setTermin(null);

		return zahtev;
	}

}