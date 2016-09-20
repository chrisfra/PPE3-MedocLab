package model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
/**
 * Classe d'objet metier MEDICAMENT
 * @author xavier
 *
 */
public class Medicine {
	/**
	 * Le nom du médicament
	 */
	private String name;
	/**
	 * Forme pharmaceutique du médicament
	 */
	private Form itsForm;
	/**
	 * Date d'obtention du brevet pharmaceutique
	 */
	private GregorianCalendar patentDate;
	/**
	 * Composition du principe actif
	 */
	private Composition compoPrincipal;
	/**
	 * Composition de l'excipient
	 */
	private Composition compoExcipient;
	/**
	 * Liste statique de tous les médicaments
	 */
	public static ArrayList<Medicine> allTheMedicines = new ArrayList<Medicine>();
	
	/**
	 * Construcuteur de la classe Medicament
	 * @param name nom du nouveau médicament
	 * @param itsForm forme pharmaceutique du nouveau médicament
	 * @param patentDate date d'obtention du brevet du nouveau médicament
	 */
	public Medicine(String name, Form itsForm, GregorianCalendar patentDate, Composition compoPrincipal, Composition compoExcipient) {
		super();
		this.name = name;
		this.itsForm = itsForm;
		this.patentDate = patentDate;
		this.compoPrincipal = compoPrincipal;
		this.compoExcipient = compoExcipient;
		
		allTheMedicines.add(this);
	}

	/**
	 * Accesseur en lecture sur le nom du médicament
	 * @return le nom du médicament
	 */
	public String getName() {
		return name;
	}

	/**
	 * Accesseur en lecture sur la forme du médicament
	 * @return la forme du médicament
	 */
	public Form getItsForm() {
		return itsForm;
	}

	/**
	 * Accesseur en lecture sur la date d'obtention du brevet du médicament
	 * @return la date d'obtention du brevet du médicament
	 */
	public GregorianCalendar getPatentDate() {
		return patentDate;
	}
	
	/**
	 * Accesseur en lecture sur le principe actif
	 * @return le principe actif
	 */
	public Composition getPrincipeActif()
	{
		return this.compoPrincipal;
	}
	
	/**
	 * Accesseur en lecture sur l'excipient
	 * @return l'excipient
	 */
	public Composition getExcipient()
	{
		return this.compoExcipient;
	}
	
	/**
	 * Méthode permettant de rechercher parmi tous les médicaments
	 * celui ayant un nom correspondant à celui passé en paramètre
	 * @param name le nom à rechercher
	 * @return le Medicament correspondant
	 */
	public static Medicine getMedicineByName(String name) {
		Medicine found = null;
		for(Medicine m : Medicine.allTheMedicines){
			if(m.getName().equals(name))
				found=m;
		}
		return found;
	}

	/**
	 * Accesseur en écriture sur la forme du médicament
	 * @param itsForm la nouvelle forme du médicament
	 */
	public void setItsForm(Form itsForm) {
		this.itsForm = itsForm;
	}

	/**
	 * Accesseur en écriture sur la date d'obtention du brevet du médicament
	 * @param patentDate la nouvelle date d'obtention du brevet du médicament
	 */
	public void setPatentDate(GregorianCalendar patentDate) {
		this.patentDate = patentDate;
	}

	/**
	 * Accesseur en écriture sur le principe actif du médicament
	 * @param principeActif le nouveau compoosant du médicament
	 */
	public void setPrincipeActif(Composition principeActif) {
		this.compoPrincipal = principeActif;
	}

	/**
	 * Accesseur en écriture sur l'excipient du médicament
	 * @param excipient le nouveau compoosant du médicament
	 */
	public void setExcipient(Composition excipient) {
		this.compoExcipient = excipient;
	}
}
