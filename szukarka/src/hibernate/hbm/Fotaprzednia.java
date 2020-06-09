
©all rights reserved.


package hibernate.hbm;
// Generated 2019-05-02 01:55:28 by Hibernate Tools 4.3.1.Final

/**
 * Fotaprzednia generated by hbm2java
 */
public class Fotaprzednia implements java.io.Serializable {

	private int idFotaprzed;
	private Laptop laptop;
	private String nazwa;
	private byte[] wartosci;

	public Fotaprzednia() {
	}

	public Fotaprzednia(int idFotaprzed) {
		this.idFotaprzed = idFotaprzed;
	}

	public Fotaprzednia(int idFotaprzed, Laptop laptop, String nazwa, byte[] wartosci) {
		this.idFotaprzed = idFotaprzed;
		this.laptop = laptop;
		this.nazwa = nazwa;
		this.wartosci = wartosci;
	}

	public int getIdFotaprzed() {
		return this.idFotaprzed;
	}

	public void setIdFotaprzed(int idFotaprzed) {
		this.idFotaprzed = idFotaprzed;
	}

	public Laptop getLaptop() {
		return this.laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public byte[] getWartosci() {
		return this.wartosci;
	}

	public void setWartosci(byte[] wartosci) {
		this.wartosci = wartosci;
	}

}
