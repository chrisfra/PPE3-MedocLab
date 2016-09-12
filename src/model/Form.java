package model;

import java.util.ArrayList;
/**
 * Classe d'objet metier FORME
 * @author xavier
 * 
 */
public class Form {
	/**
	 * Identifiant de la forme
	 */
	private int id;
	/**
	 * Nom de la forme
	 */
	private String name;
	/**
	 * Liste statique de toutes les formes
	 */
	public static ArrayList<Form> allTheForms = new ArrayList<Form>();
	
	/**
	 * Constructeur de la classe Forme
	 * @param id identifiant de la nouvelle forme
	 * @param name nom de la nouvelle forme
	 */
	public Form(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		allTheForms.add(this);
	}
	/**
	 * Accesseur en lecture sur l'identifiant de la forme
	 * @return l'identifiant de la forme
	 */
	public int getId(){
		return id;
	}
	
	/**
	 * Accesseur en lecture sur le nom de la forme
	 * @return le nom de la forme
	 */
	public String getName() {
		return name;
	}
	/**
	 * Méthode permettant de rechercher parmi toutes les formes
	 * celle ayant un identifiant correspondant à celui passé en paramètre
	 * @param id l'identifiant à rechercher
	 * @return la Forme correspondante
	 */
	public static Form getFormById(int id){
		Form found = null;
		for(Form f : Form.allTheForms){
			if(f.getId()==id)
				found=f;
		}
		return found;
	}
	/**
	 * Méthode permettant de rechercher parmi toutes les formes
	 * celle ayant un nom correspondant à celui passé en paramètre
	 * @param name le nom à rechercher
	 * @return la Forme correspondante
	 */
	public static Form getFormByName(String name) {
		Form found = null;
		for(Form f : Form.allTheForms){
			if(f.getName().equals(name))
				found=f;
		}
		return found;
	}

}
