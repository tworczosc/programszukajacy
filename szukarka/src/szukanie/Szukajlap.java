
©all rights reserved.


package szukanie;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import hibernate.Helper;
import hibernate.hbm.Grafika;
import hibernate.hbm.Laptop;
import hibernate.hbm.ProcesorChipset;
import kolorado.Wfinterface;
import zamowienia.Listalap;



@SessionScoped
@Named("Szukajlap")
public class Szukajlap implements Serializable,Inteszukuruchom{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8608588012115795162L;
	private boolean rendszuk=false;
	private String szukajl="";
	private SelectItem[] listaszuk;
		List<Szukselectitem> szukl = new ArrayList<Szukselectitem>();

		private char[] chara;

		private char[] charf;
		private List<Integer> charc=new ArrayList<Integer>();
		private String charlast="";
		private char litera = 0;
		private String dodallast="";
		private List<String> laplista = new ArrayList<String>();
		private List<Szukselectitem> szukaneword = new ArrayList<Szukselectitem>();
		private String czydodal="";

		private int lapiden=0;







public Szukajlap(){
		
	}

@Inject
Metszukanielap msl;


@Autowired
Metszukanielap metszukanielap;

@Autowired
Inteszukanie inteszukanie;

@Autowired
Inteszukuruchom isu;




public void szukajuruchomienie(AjaxBehaviorEvent e2)throws AbortProcessingException, IOException{
	isu.wyswietlszuk();
}



	public void wyswietlszuk() throws IOException{
		List<Object[]> listszuk = new ArrayList<Object[]>();

		metszukanielap.getSzukl().clear();
		listszuk=new Helper().listaszukanie();
		Laptop lap=new Laptop();
		Grafika graf=new Grafika();
		ProcesorChipset ps =new ProcesorChipset();
		char[] charb;
		String [] chard;
		List<String> lapword = new ArrayList<String>();

		char[] charh;
		String [] charha;

 		String word="";
int c=0;
		
 czydodal="";

String lapnazw="";


	if(szukajl.trim().compareTo("")==0){
		metszukanielap.getSzukl().clear();	
		setRendszuk(false);

		listalap.setWeslap(listalap.lapkontekst ());
		listalap.setWesprzet(listalap.sprzetkontekst ());

	
	}if(szukajl.trim().compareTo("")!=0){
		
		charb=szukajl.trim().toLowerCase().toCharArray();
	
		
		setRendszuk(true);

		
		
		
		
		
		
		try{
		
		
		
			for(int jc=0;jc<charb.length;jc++){
			if(charb[jc]==' '){charh=null;
			charh=	Arrays.copyOfRange(charb,c,jc);
			charha=	new String[charh.length];
			for(int jw=0;jw<charh.length;jw++){
				charha[jw]=Character.toString(charh[jw]);
				
			}
		 		word= String.join("", charha);
		 		
				
				lapword.add(word);
				c=jc+1;
				}					

				if(jc==charb.length-1){charh=null;
				charh=	Arrays.copyOfRange(charb,c,charb.length);
				charha=	new String[charh.length];
				for(int jw=0;jw<charh.length;jw++){
					charha[jw]=Character.toString(charh[jw]);
					
				}
			 		word= String.join("", charha);
			 		
			 		
			 		
					//	charh=	Arrays.copyOfRange(charb,c,charb.length);
		//		 		word= Arrays.toString(charh);
		
					
						
					lapword.add(word);
					
					
				
			}
			
		}
		
		
		
		//for (Object[] listalap : listszuk) {
			for (int js=0;js<listszuk.size();js++) {
				Object[] listalap=listszuk.get(js);
		lap=	(Laptop)listalap[0];
		graf=	(Grafika)listalap[1];
	//	ps=(ProcesorChipset)listalap[2];*/
		
		lapiden=lap.getIdLaptop();
 		laplista.clear();
 		metszukanielap.getSzukaneword().clear();
 		lapnazw="";
 		  charlast="";
//word=lap.getNazwaLaptopa()+" "+lap.getNazwaModelu()+" "+lap.getPlytaGlowna();
//charf=word.toLowerCase().toCharArray();



laplista.add(lap.getNazwaLaptopa());

		laplista.add(lap.getNazwaModelu());
		laplista.add(graf.getNazwaGrafiki());
		//laplista.add(lap.getPlytaGlowna());
		laplista.add(lap.getPamiecRam());
		
		

		//laplista.add(graf.getSzybkoscPamieci());

	
	searchklaw:
			for(int vwj=0;vwj<lapword.size();vwj++){
			
			dodallast="";

			
		
				
		charf=lapword.get(vwj).toCharArray();	
	searchword:
	for(int il=0;il<laplista.size();il++){
		
			
		chara=laplista.get(il).toLowerCase().toCharArray();
		charlast="";			

	
	
		chard =new String[chara.length];
		char[] chare=	laplista.get(il).toCharArray();								 


		lapnazw=lap.getNazwaLaptopa();



				
		
		Szukselectitem si=new Szukselectitem();
		si.setLapiden(lapiden);
		si.setLapnazw(lapnazw);

		
			
		
				 
	//	if(metszukanielap.getSzukl().contains(si)==false){
			if(metszukanielap.czyfound(lapiden).compareTo("t")!=0){

			if(szukajl.trim().toLowerCase().compareTo(laplista.get(il).toLowerCase())==0){	
				if(il==0){	
			 		lapnazw=lap.getNazwaLaptopa();	Szukselectitem sin = new Szukselectitem();	
					sin.setLapiden(lapiden);
					sin.setLapnazw(lapnazw);	
					metszukanielap.getSzukl().add(sin);
	//				lapnazw=lap.getNazwaLaptopa() + " "+laplista.get(il);	

				                   }
	 	if(il!=0){	
	 		
	 		String lapnazwbold="";
	 		
					 
	 		lapnazwbold="<b>"+szukajl.trim()+"</b>";
			
	 		

	 		
	 		lapnazw=lap.getNazwaLaptopa();
	 		Szukselectitem sin = new Szukselectitem();	
			sin.setLapiden(lapiden);
			sin.setLapnazw(lapnazw);	
	 	sin.setLapklaw(lapnazwbold);
		metszukanielap.getSzukl().add(sin);
}
			
			
				
		//	getSzukl().add(laplista.get(il));
	 		
		} }
		
		

		
		//if(metszukanielap.getSzukl().contains(si)==false){
if(metszukanielap.czyfound(lapiden).compareTo("t")!=0){
		
			if(		wyszukajchar().compareTo("t")==0){
				dodallast="t";

			}
							

		if(il==laplista.size()-1){
		if(dodallast.compareTo("t")!=0){	
			
			if(js==listszuk.size()-1){
				
			
					if(metszukanielap.getSzukl().isEmpty()==true){
		Szukselectitem sieror=new Szukselectitem();
		
		
		sieror.setLapklaw("Podaj inna fraze");

			
		//if(metszukanielap.getSzukl().contains(sieror)==false){

		
		metszukanielap.getSzukl().add(sieror);	}}
	 
			break searchklaw;

			
		}
			

						for(int jdodal=0;jdodal<metszukanielap.getSzukaneword().size();jdodal++){
									if(metszukanielap.getSzukaneword().get(jdodal).getLapiden()==lapiden){
										czydodal="t";
										
									}
									if(jdodal==metszukanielap.getSzukaneword().size()-1){

										if(czydodal.compareTo("t")!=0){
																		break searchklaw;

											
										}
										
									}
									
								//}                     			
									
				
			//ica roznic		

					}										 
												 
												 
					//icacxharf						 
				}
				
				
		
							

							
		if(		charlast.compareTo("t")==0){
			
							for(int v=0;v<charc.size();v++){
									int jc= charc.get(v);
								 
									chard[jc]="<b>"+chare[jc]+"</b>";
									}



											for(int jd=0;jd<chard.length;jd++){
												
												if(chard[jd]==null){
													
													chard[jd]=Character.toString(chara[jd]);
												

												}}
				 
							 if(il==0){		
									//	sipodz=new Szukselectitem();	
								
								 for(int nazwkasuj=0;nazwkasuj<metszukanielap.getSzukaneword().size();nazwkasuj++){
										if(metszukanielap.getSzukaneword().get(nazwkasuj).getLapnazw().isEmpty()!=true){
											metszukanielap.getSzukaneword().get(nazwkasuj).setLapnazw("");		
										}
										
										
									}
									/*	sipodz.setLapnazw(String.join("", chard));
										sipodz.setLapklaw("");*/
							//	 Inteszukanie is=new Metszukanielap();
								 
								 inteszukanie.dodajword(lapiden,String.join("", chard),"");	 
													
								 }
			
							 
							 
							 if(il>0){		
									
								 
								 
								 
								 if(	metszukanielap.getSzukaneword().isEmpty()==false){	

							 
									 if(	metszukanielap.getSzukaneword().get(0).getLapiden()==lapiden){
											/*sipodz=new Szukselectitem();	
											sipodz.setLapiden(lapiden);	
											sipodz.setLapnazw("");

									 sipodz.setLapklaw(String.join("", chard));*/
										 inteszukanie.dodajword(lapiden,"",String.join("", chard));	 
									 
								 }} 
								 
						 
								 if(metszukanielap.getSzukaneword().isEmpty()==true){
		
									 inteszukanie.dodajword(lapiden,lap.getNazwaLaptopa(),String.join("", chard));
				 }
		 										 
							}}
				if(metszukanielap.getSzukaneword().isEmpty()==false){					
				
					if(vwj==lapword.size()-1)		{	
						if(il==laplista.size()-1){
					
							inteszukanie.polaczszukanyword();
							
						
									
									if(metszukanielap.getSzukl().isEmpty()==false){
										
										inteszukanie.dodajpelny(lapiden);			

											//	getSzukl().set(0,	si);
							}

								if(metszukanielap.getSzukl().isEmpty()==true){

									
									inteszukanie.dodajpusty(lapiden);		 
												
						}
													
									if(lapword.size()!=metszukanielap.getSzukaneword().size())	{						
										metszukanielap.getSzukaneword().clear();}								

									}			
									
			//vwj size				
					}
									
			//		break searchword;
				}
		
				
				
							 
				//czy istniejace
}


					 }										 
												 
	
				//petlacha
					}

			}
			
		
		} catch(ArrayIndexOutOfBoundsException aie){
			System.out.println("arayboundse"+aie);

			taberor();
		}
	 catch(IllegalArgumentException iae){
		System.out.println("ilegale"+iae);

		taberor();
	} catch(NullPointerException npe){
		System.out.println("nule"+npe);

		taberor();
		} catch(IndexOutOfBoundsException ie){
			System.out.println("ibounde"+ie);

			taberor();
		
	}}
		}
	
	
	private void taberor() throws IOException{
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    ec.redirect(ec.getRequestContextPath() + "/eror/szukanyeror.xhtml");
	
		

		
	}
		
		public String wyszukajchar(){char lita='0';
		
	//	if(metszukanielap.czyfound(lapiden).compareTo("t")!=0){	
		String lastchar="";

		
		charc.clear();
			search:
				for(int ica=0;ica<charf.length;ica++){
					if(ica<chara.length){
						if	(chara[ica]==  charf[ica]){	
							charc.add(ica);
 							if(ica==charf.length-1){
								charlast="t";			
 								
							}
						}
		 
						if	(chara[ica]!=  charf[ica]){
							charc.clear();	
 					 searcha:
								 for(int ic=0;ic<charf.length;ic++){litera = 0;
							
				          				 for(int jc=0;jc<chara.length;jc++){

											if	(charf[ic]==chara[jc]){
												charc.add(jc);
 								
											litera='t';
											}
																		
						if (jc==chara.length-1)	
						{			
								
							if(litera!='t')	{	
 								charlast="";	
							charc.clear();
							break	search;	

					}
							if (ic==charf.length-1)	
							{	  if(litera=='t')	{									charlast="t";			

 		}							break	search;	


							}

								
								
						
						}}}}}}
				
						return charlast;
						
				}

	
			
			 
			
			
		
		
		@Autowired
		Listalap listalap;
	
		@Autowired
		Wfinterface wfinterface;
	
public void outcomeszukany(int wesl) throws IOException {
	
	  	inteszukanie.weslap(wesl);
	inteszukanie.wesfot(wesl);

	 
	setRendszuk(false);
setSzukajl("");
	
	
	ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
  ec.redirect(ec.getRequestContextPath() + "/transaction/szukanysprzet.xhtml");
	 
}

	
	
	public boolean isRendszuk() {
		return rendszuk;
	}

	public void setRendszuk(boolean rendszuk) {
		this.rendszuk = rendszuk;
	}
	
	public SelectItem[] getListaszuk() {
		return listaszuk;
	}

	public void setListaszuk(SelectItem[] listaszuk) {
		this.listaszuk = listaszuk;
	}

	

	public List<Szukselectitem> getSzukl() {
		return szukl;
	}

	public void setSzukl(List<Szukselectitem> szukl) {
		this.szukl = szukl;
	}

	public String getSzukajl() {
		return szukajl;
	}

	public void setSzukajl(String szukajl) {
		this.szukajl = szukajl;
	}

	


}
