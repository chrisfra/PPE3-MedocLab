package view;

import controller.Ctrl;

/**
 * Interface MyView permettant à toutes les vues de l'application d'implémenter la méthode contenue dans celle-ci
 * @author xavier
 *
 */
public interface MyView {
	
	/**
	 * Méthode abstraite (sans corps) donc à rédéfinir dans toutes les classes filles.
	 * Cette méthode a pour objectif de définir un observateur sur la vue fille.
	 * Cet observateur sera une instance de la classe Ctrl
	 * @param ctrl L'observateur de la future vue
	 */
	public abstract void assignListener(Ctrl ctrl);

}
