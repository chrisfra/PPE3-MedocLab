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
	 * Le nom du m�dicament
	 */
	private String name;
	/**
	 * Forme pharmaceutique du m�dicament
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
	 * Liste statique de tous les m�dicaments
	 */
	public static ArrayList<Medicine> allTheMedicines = new ArrayList<Medicine>();
	
	/**
	 * Construcuteur de la classe Medicament
	 * @param name nom du nouveau m�dicament
	 * @param itsForm forme pharmaceutique du nouveau m�dicament
	 * @param patentDate date d'obtention du brevet du nouveau m�dicament
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
	 * Accesseur en lecture sur le nom du m�dicament
	 * @return le nom du m�dicament
	 */
	public String getName() {
		return name;
	}

	/**
	 * Accesseur en lecture sur la forme du m�dicament
	 * @return la forme du m�dicament
	 */
	public Form getItsForm() {
		return itsForm;
	}

	/**
	 * Accesseur en lecture sur la date d'obtention du brevet du m�dicament
	 * @return la date d'obtention du brevet du m�dicament
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
	 * M�thode permettant de rechercher parmi tous les m�dicaments
	 * celui ayant un nom correspondant � celui pass� en param�tre
	 * @param name le nom � rechercher
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
	 * Accesseur en �criture sur la forme du m�dicament
	 * @param itsForm la nouvelle forme du m�dicament
	 */
	public void setItsForm(Form itsForm) {
		this.itsForm = itsForm;
	}

	/**
	 * Accesseur en �criture sur la date d'obtention du brevet du m�dicament
	 * @param patentDate la nouvelle date d'obtention du brevet du m�dicament
	 */
	public void setPatentDate(GregorianCalendar patentDate) {
		this.patentDate = patentDate;
	}

	/**
	 * Accesseur en �criture sur le principe actif du m�dicament
	 * @param principeActif le nouveau compoosant du m�dicament
	 */
	public void setPrincipeActif(Composition principeActif) {
		this.compoPrincipal = principeActif;
	}

	/**
	 * Accesseur en �criture sur l'excipient du m�dicament
	 * @param excipient le nouveau compoosant du m�dicament
	 */
	public void setExcipient(Composition excipient) {
		this.compoExcipient = excipient;
	}
}
