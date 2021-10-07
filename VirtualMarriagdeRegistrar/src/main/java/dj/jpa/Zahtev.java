package dj.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the zahtev database table.
 * 
 */
@Entity
@NamedQuery(name="Zahtev.findAll", query="SELECT z FROM Zahtev z")
public class Zahtev implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ZAHTEV_ID_GENERATOR", sequenceName="ZAHTEV_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ZAHTEV_ID_GENERATOR")
	private Integer id;

	private String adresa;

	@Column(name="izlaz_maticara")
	private Boolean izlazMaticara;

	@Column(name="pdf_dokaz_uplata")
	private byte[] pdfDokazUplata;

	@Column(name="pdf_dokaz_uplata_izlazak")
	private byte[] pdfDokazUplataIzlazak;

	@Column(name="strani_drzavljanin_muz")
	private Boolean straniDrzavljaninMuz;

	@Column(name="strani_drzavljanin_zena")
	private Boolean straniDrzavljaninZena;

	//bi-directional many-to-one association to Muz
	@ManyToOne
	@JoinColumn(name="muz")
	private Muz muz;

	//bi-directional many-to-one association to Termin
	@ManyToOne
	@JoinColumn(name="termin")
	private Termin termin;

	//bi-directional many-to-one association to Zena
	@ManyToOne
	@JoinColumn(name="zena")
	private Zena zena;

	public Zahtev() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Boolean getIzlazMaticara() {
		return this.izlazMaticara;
	}

	public void setIzlazMaticara(Boolean izlazMaticara) {
		this.izlazMaticara = izlazMaticara;
	}

	public byte[] getPdfDokazUplata() {
		return this.pdfDokazUplata;
	}

	public void setPdfDokazUplata(byte[] pdfDokazUplata) {
		this.pdfDokazUplata = pdfDokazUplata;
	}

	public byte[] getPdfDokazUplataIzlazak() {
		return this.pdfDokazUplataIzlazak;
	}

	public void setPdfDokazUplataIzlazak(byte[] pdfDokazUplataIzlazak) {
		this.pdfDokazUplataIzlazak = pdfDokazUplataIzlazak;
	}

	public Boolean getStraniDrzavljaninMuz() {
		return this.straniDrzavljaninMuz;
	}

	public void setStraniDrzavljaninMuz(Boolean straniDrzavljaninMuz) {
		this.straniDrzavljaninMuz = straniDrzavljaninMuz;
	}

	public Boolean getStraniDrzavljaninZena() {
		return this.straniDrzavljaninZena;
	}

	public void setStraniDrzavljaninZena(Boolean straniDrzavljaninZena) {
		this.straniDrzavljaninZena = straniDrzavljaninZena;
	}

	public Muz getMuz() {
		return this.muz;
	}

	public void setMuz(Muz muz) {
		this.muz = muz;
	}

	public Termin getTermin() {
		return this.termin;
	}

	public void setTermin(Termin termin) {
		this.termin = termin;
	}

	public Zena getZena() {
		return this.zena;
	}

	public void setZena(Zena zena) {
		this.zena = zena;
	}

}