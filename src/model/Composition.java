package model;

import java.util.ArrayList;

/**
 * Classe d'objet metier Model
 * @author sullivan
 * 
 */
public class Composition {
	/**
	 * Identifiant de la composition
	 */
	private int id;
	/**
	 * Nom de la composition
	 */
	private String name;
	
	/**
	 * Liste statique de toutes les compositions
	 */
	public static ArrayList<Composition> allTheComposition = new ArrayList<Composition>();
	
	/**
	 * Constructeur de la classe Composition
	 * @param id identifiant de la nouvelle composition
	 * @param name nom de la nouvelle composition
	 */
	public Composition(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		
		allTheComposition.add(this);
	}
	
	/**
	 * Accesseur en lecture sur le nom de la Composition
	 * @return le nom de la forme
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Accesseur en lecture sur l'identifiant de la Composition
	 * @return l'identifiant de la composition
	 */
	public int getId(){
		return id;
	}

	public static Composition getCompositionByName(String nomC_PrincipeActif) {
		Composition composition = null;
		for(Composition c : Composition.allTheComposition){
			if(c.getName().equals(nomC_PrincipeActif))
				composition=c;
		}
		return composition;
	}
}