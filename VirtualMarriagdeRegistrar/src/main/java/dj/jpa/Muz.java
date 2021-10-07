package dj.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the muz database table.
 * 
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@NamedQuery(name="Muz.findAll", query="SELECT m FROM Muz m")
public class Muz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MUZ_ID_GENERATOR", sequenceName="MUZ_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MUZ_ID_GENERATOR")
	private Integer id;

	@Column(name="br_licnekarte")
	private String brLicnekarte;

	@Column(name="broj_pasosa")
	private String brojPasosa;

	private String email;

	@Column(name="govori_srpski")
	private Boolean govoriSrpski;

	private String ime;

	private String jmbg;

	@Column(name="pdf_licnakarta")
	private byte[] pdfLicnakarta;

	@Column(name="pdf_mkrodjenih")
	private byte[] pdfMkrodjenih;

	@Column(name="pdf_pasos")
	private byte[] pdfPasos;

	@Column(name="pdf_uverenje")
	private byte[] pdfUverenje;

	private String prz;

	private String telefon;

	//bi-directional many-to-one association to Zahtev
	@JsonIgnore
	@OneToMany(mappedBy="muz")
	private List<Zahtev> zahtevs;

	public Muz() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrLicnekarte() {
		return this.brLicnekarte;
	}

	public void setBrLicnekarte(String brLicnekarte) {
		this.brLicnekarte = brLicnekarte;
	}

	public String getBrojPasosa() {
		return this.brojPasosa;
	}

	public void setBrojPasosa(String brojPasosa) {
		this.brojPasosa = brojPasosa;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getGovoriSrpski() {
		return this.govoriSrpski;
	}

	public void setGovoriSrpski(Boolean govoriSrpski) {
		this.govoriSrpski = govoriSrpski;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getJmbg() {
		return this.jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public byte[] getPdfLicnakarta() {
		return this.pdfLicnakarta;
	}

	public void setPdfLicnakarta(byte[] pdfLicnakarta) {
		this.pdfLicnakarta = pdfLicnakarta;
	}

	public byte[] getPdfMkrodjenih() {
		return this.pdfMkrodjenih;
	}

	public void setPdfMkrodjenih(byte[] pdfMkrodjenih) {
		this.pdfMkrodjenih = pdfMkrodjenih;
	}

	public byte[] getPdfPasos() {
		return this.pdfPasos;
	}

	public void setPdfPasos(byte[] pdfPasos) {
		this.pdfPasos = pdfPasos;
	}

	public byte[] getPdfUverenje() {
		return this.pdfUverenje;
	}

	public void setPdfUverenje(byte[] pdfUverenje) {
		this.pdfUverenje = pdfUverenje;
	}

	public String getPrz() {
		return this.prz;
	}

	public void setPrz(String prz) {
		this.prz = prz;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public List<Zahtev> getZahtevs() {
		return this.zahtevs;
	}

	public void setZahtevs(List<Zahtev> zahtevs) {
		this.zahtevs = zahtevs;
	}

	public Zahtev addZahtev(Zahtev zahtev) {
		getZahtevs().add(zahtev);
		zahtev.setMuz(this);

		return zahtev;
	}

	public Zahtev removeZahtev(Zahtev zahtev) {
		getZahtevs().remove(zahtev);
		zahtev.setMuz(null);

		return zahtev;
	}

}