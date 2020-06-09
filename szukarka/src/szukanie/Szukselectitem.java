package szukanie;

public class Szukselectitem {

	private int lapiden;
	private String lapnazw;
	private String lapklaw;

	public Szukselectitem() {
		// TODO Auto-generated constructor stub
	}
	
	public Szukselectitem(int lapiden, String lapnazw, String lapklaw) {
		super();
		this.lapiden = lapiden;
		this.lapnazw = lapnazw;
		this.lapklaw = lapklaw;

	}



	



	public int getLapiden() {
		return lapiden;
	}



	public void setLapiden(int lapiden) {
		this.lapiden = lapiden;
	}



	public String getLapklaw() {
		return lapklaw;
	}

	public void setLapklaw(String lapklaw) {
		this.lapklaw = lapklaw;
	}

	public String getLapnazw() {
		return lapnazw;
	}



	public void setLapnazw(String lapnazw) {
		this.lapnazw = lapnazw;
	}

}
