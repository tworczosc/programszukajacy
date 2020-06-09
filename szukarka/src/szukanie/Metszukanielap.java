package szukanie;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialResponseWriter;
import javax.faces.context.PartialViewContext;
import javax.inject.Named;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import hibernate.hbm.Fotaprzednia;
import hibernate.hbm.Konto;
import hibernate.hbm.Laptop;
import zamowienia.Listalap;
import zamowienia.Pokazlap;

@Named("Metszukanielap")
public class Metszukanielap implements  Serializable, Inteszukanie{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3437979468662152677L;
	List<Szukselectitem> szukaneword = new ArrayList<Szukselectitem>();
	List<Szukselectitem> szukl = new ArrayList<Szukselectitem>();
	private SessionFactory sessionFactory;


	@Autowired
	Pokazlap pokazlap;
	
	@Autowired
	Listalap listalap;
	
	
	public Metszukanielap() {
		// TODO Auto-generated constructor stub
	}
public void dodajword(int lapiden, String lnazw,String lklaw){
		
		Szukselectitem sipodz=new Szukselectitem();	
		sipodz.setLapiden(lapiden);	
		sipodz.setLapnazw(lnazw);
		sipodz.setLapklaw(lklaw);
		if(szukaneword.contains(sipodz)==false){szukaneword.add(sipodz);}
		
		
	 
	}

 public void polaczszukanyword() throws IOException{
	String wordnazwbold="";
	String wordklawbold="";
	int boldiden=0;

	wordklawbold="";	
	
	
	for(Szukselectitem sw:(List<Szukselectitem>) szukaneword)	{

		if(sw.getLapnazw().compareTo("")!=0){
			wordnazwbold=sw.getLapnazw();					

			
			
		}
		
		wordklawbold=wordklawbold+" "+sw.getLapklaw();
		
 boldiden=	sw.getLapiden();			
 
	}	
 	
	
 Szukselectitem swb=new Szukselectitem();
		swb.setLapiden(boldiden);
	swb.setLapnazw(wordnazwbold);
	swb.setLapklaw(wordklawbold);
	szukaneword.set(0, swb);

	 
	
	
	
}


@SuppressWarnings("unchecked")
@Transactional
public void weslap(int lapiden){
	
		
		 
	List<Laptop>	lap=new ArrayList<Laptop>();
	try {


	 
		lap	= sessionFactory.getCurrentSession().createQuery("select   distinct l  from Laptop  l   inner join l.fotaprzednias  f where l.idLaptop="+lapiden+""    ).getResultList();
	 

		listalap.setWesprzet(lap);

			} catch (Exception e) {
				e.printStackTrace();
			}
			
	
}



public List<Szukselectitem> getSzukl() {
	return szukl;
}
public void setSzukl(List<Szukselectitem> szukl) {
	this.szukl = szukl;
}

public List<Szukselectitem> getSzukaneword() {
	return szukaneword;
}
public void setSzukaneword(List<Szukselectitem> szukaneword) {
	this.szukaneword = szukaneword;
}


public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}


}





