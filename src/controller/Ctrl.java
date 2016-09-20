package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import library.DatesConverter;
import library.Persistence;
import model.Composition;
import model.Form;
import model.Medicine;
import view.MedicineAdd;
import view.MedicineChange;
import view.MedicineHome;
import view.MedicineSearch;
/**
 * Classe CONTROLEUR
 * @author xavier
 *
 */
public class Ctrl implements ActionListener, MouseListener{
	
	/**
	 * Constructeur de la classe Ctrl
	 * Ce constructeur permet, en plus de cr�er une instance de Ctrl, de cr�er tous les objets de l'application � partir de la base de donn�es
	 */
	public Ctrl(){
		//Cr�ation des objets Forme
		String[][] dataForm = null;
		try {
			dataForm = Persistence.load("forme");
		} catch (SQLException e) {
			String message = "Erreur lors de l'echange avec la base de donn�es. L'application a rencontr�e l'erreur : "+e.getMessage();
			JOptionPane.showMessageDialog(null,message,"Erreur SQL",JOptionPane.ERROR_MESSAGE);
		}
		for(int i=0;i<dataForm.length;i++){
			new Form(Integer.parseInt(dataForm[i][0]),dataForm[i][1]);
		}
		//Cr�ation des objets Composition
				String[][] dataComp = null;
				try {
					dataComp = Persistence.load("composition");
				} catch (SQLException e) {
					String message = "Erreur lors de l'echange avec la base de donn�es. L'application a rencontr�e l'erreur : "+e.getMessage();
					JOptionPane.showMessageDialog(null,message,"Erreur SQL",JOptionPane.ERROR_MESSAGE);
				}
				for(int i=0;i<dataComp.length;i++){
					new Composition(Integer.parseInt(dataComp[i][0]),dataComp[i][1]);
				}
		//Cr�ation des objets Medicine
		String[][] dataMed = null;
		try {
			dataMed = Persistence.load("medicament");
		} catch (SQLException e) {
			String message = "Erreur lors de l'echange avec la base de donn�es. L'application a rencontr�e l'erreur : "+e.getMessage();
			JOptionPane.showMessageDialog(null,message,"Erreur SQL",JOptionPane.ERROR_MESSAGE);
		}
		for(int i=0;i<dataMed.length;i++){
			new Medicine(dataMed[i][1],Form.getFormById(Integer.parseInt(dataMed[i][5])),DatesConverter.USStringToDate(dataMed[i][2]),Composition.getCompositionById(Integer.parseInt(dataMed[i][6])),Composition.getCompositionById(Integer.parseInt(dataMed[i][7])));
		}
	}

	/**
	 * M�thode d�clanch�e lors de clics sur les boutons de l'application
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		//R�cup�ration de l'action
		String action = evt.getActionCommand();
		//D�coupage et analyse de celle-ci
		String details[] = action.split("_");
		//who : QUI ? Quelle vue a effectu� l'action ?
		String who = details[0];
		//what : QUOI ? Qu'est-ce-que cette vue souhaite faire ?
		String what = details[1];
		//switch-case de traitement des diff�rents cas
		switch(who){
		case "MainView":
			switch(what){
			case "export":
				break;
			case "manuel":
				//Cr�ation de la vue d'accueil des m�dicaments
				MedicineHome frame = new MedicineHome();
				//Assignation d'un observateur sur cette vue
				frame.assignListener(this);
				//Affichage de la vue
				frame.setVisible(true);
				break;
			}
			break;
		case "MedicineHome":
			switch(what){
			case "ajout":
				//Cr�ation de la vue d'ajout d'un m�dicament
				MedicineAdd frame = new MedicineAdd(this.formsBox(),this.compositionsBox());
				//Assignation d'un observateur sur cette vue
				frame.assignListener(this);
				//Affichage de la vue
				frame.setVisible(true);
				break;
			case "rechercherModifier":				
				String[][] dataTable = this.medicinesTable();
				String[] dataColumns = {"Nom","Forme","Brevet","Principe","Excipient"};
				//Cr�ation de la vue de recherche d'un m�dicament
				MedicineSearch frame1 = new MedicineSearch(dataTable,dataColumns);
				//Assignation d'un observateur sur cette vue
				frame1.assignListener(this);
				//Affichage de la vue
				frame1.setVisible(true);
				break;
			}
			break;
		case "MedicineAdd":
			switch(what){
			case "valider":
				//R�cup�ration des informations saisies par l'utilisateur
				String nom = MedicineAdd.getTxtName();
				if(nom.equals("")){
					JOptionPane.showMessageDialog(null,"Le nom du m�dicament � �t� omis. Veillez � le saisir correctement.","Erreur Saisie",JOptionPane.WARNING_MESSAGE);
					MedicineAdd.focusTxtName();
				}
				else{
					String nomF = MedicineAdd.getTxtForm();
					Form forme = Form.getFormByName(nomF);
					String dateB = MedicineAdd.getTxtPatentDate();
					String nomC_PrincipeActif = MedicineAdd.getTxtComposition_PrincipeActif();
					String nomC_Exicipient = MedicineAdd.getTxtComposition_Exicipient();
					Composition composition_PrincipeActif = Composition.getCompositionByName(nomC_PrincipeActif);
					Composition composition_Exicipient = Composition.getCompositionByName(nomC_Exicipient);
					//Cr�ation du nouvel objet Medicine
					Medicine med = new Medicine(nom,forme,DatesConverter.FRStringToDate(dateB),composition_PrincipeActif,composition_Exicipient);
					//INSERT dans la BD
					try {
						Persistence.insertMedicine(med.getName(),med.getItsForm().getId(),med.getPatentDate(),composition_PrincipeActif.getId(), composition_Exicipient.getId());
						//Message de confirmation pour l'utilisateur
						JOptionPane.showMessageDialog(null,"Le m�dicament a bien �t� ajout�","Confirmation Enregistrement",JOptionPane.INFORMATION_MESSAGE);
						//R�initialisation des champs
						MedicineAdd.init();
					} catch (SQLException e) {
						String message = "Erreur lors de l'echange avec la base de donn�es. L'application a rencontr�e l'erreur : "+e.getMessage();
						JOptionPane.showMessageDialog(null,message,"Erreur SQL",JOptionPane.ERROR_MESSAGE);
					}
				}
				break;
			case "annuler":
				//R�initialisation des champs
				MedicineAdd.init();
				break;
			}
			break;
		case "MedicineSearch":
				break;
		case "MedicineChange":
			switch(what){
			case "valider":
				//R�cup�ration des informations saisies par l'utilisateur
				String nom = MedicineChange.getTxtName();
				String nomF = MedicineChange.getTxtForm();
				Form forme = Form.getFormByName(nomF);
				String dateB = MedicineChange.getTxtPatentDate();
				//R�cup�ration de l'objet Medicine � modifier
				Medicine med = Medicine.getMedicineByName(nom);
				String nomC_PrincipeActif = MedicineChange.getTxtComposition_PrincipeActif();
				String nomC_Exicipient = MedicineChange.getTxtComposition_Exicipient();
				Composition principeActif = Composition.getCompositionByName(nomC_PrincipeActif);
				Composition excipient = Composition.getCompositionByName(nomC_Exicipient);
				//Modification de celui-ci � travers les setteurs
				med.setItsForm(forme);
				med.setPatentDate(DatesConverter.FRStringToDate(dateB));
				med.setPrincipeActif(principeActif);
				med.setExcipient(excipient);
				//UPDATE dans la BD
				try {
					Persistence.updateMedicine(med.getName(),med.getItsForm().getId(),med.getPatentDate(),principeActif.getId(),excipient.getId());
					//Mise � jour de la jtable
					String[][] dataTable = this.medicinesTable();
					String[] dataColumns = {"Nom","Forme","Brevet","Principe","Excipient"};
					MedicineSearch.setTable(dataTable, dataColumns);
					//Modification du bouton (annuler devient fermer)
					MedicineChange.btnAnnuler.setText("Fermer");
					//Message de confirmation pour l'utilisateur
					JOptionPane.showMessageDialog(null,"Le m�dicament a bien �t� modifi�","Confirmation Enregistrement",JOptionPane.INFORMATION_MESSAGE);					
				} catch (SQLException e) {
					String message = "Erreur lors de l'echange avec la base de donn�es. L'application a rencontr�e l'erreur : "+e.getMessage();
					JOptionPane.showMessageDialog(null,message,"Erreur SQL",JOptionPane.ERROR_MESSAGE);
				}
				break;
			}
			break;
		}	
	}

	/**
	 * M�thode permettant d'interroger le mod�le afin de construire un tableau contenant tous les m�dicaments
	 * @return un tableau � deux dimensions contenant tous les m�dicaments (nom,idForme,dateBrevet,principeActif,excipient)
	 */
	private String[][] medicinesTable() {
		int i=0;
		String[][] liste=new String[Medicine.allTheMedicines.size()][5];
		
		for(Medicine m : Medicine.allTheMedicines){
			liste[i][0]=m.getName();
			liste[i][1]=m.getItsForm().getName();
			liste[i][2]=DatesConverter.dateToStringFR(m.getPatentDate());
			liste[i][3]=m.getPrincipeActif().getName();
			liste[i][4]=m.getExcipient().getName();
			i++;
		}
		return liste;
	}

	/**
	 * M�thode permettant d'interroger le mod�le afin de construire un tableau contenant toutes les formes
	 * @return un tableau � une dimension contenant toutes les formes (nom)
	 */
	private String[] formsBox(){
		int i=0;
		String[] liste=new String[Form.allTheForms.size()];
		for(Form l : Form.allTheForms){
			liste[i]=l.getName();
			i++;
		}
		return liste;
	}
	
	/**
	 * M�thode permettant d'interroger le mod�le afin de construire un tableau contenant toutes les compositions
	 * @return un tableau � une dimension contenant toutes les compositions (nom)
	 */
	private String[] compositionsBox(){
		int i=0;
		String[] liste=new String[Composition.allTheComposition.size()];
		for(Composition l : Composition.allTheComposition){
			liste[i]=l.getName();
			System.out.println(l.getName());
			i++;
		}
		return liste;
	}

	/**
	 * M�thode d�clanch�e lors de clics souris sur l'application
	 */
	@Override
	public void mouseClicked(MouseEvent evt) {
		//S'il s'agit d'un double-clic
		if(evt.getClickCount()==2){
			//R�cup�ration de la jtable dans laquelle l'utilisateur a double-cliqu�
			JTable laTable = (JTable)evt.getComponent();
			//R�cup�ration du num�ro de la ligne de cette jtable sur laquelle il a double-cliqu�
			int row=laTable.rowAtPoint(evt.getPoint());
			//R�cup�ration du m�dicament � partir de ces informations
			Medicine med = Medicine.getMedicineByName(laTable.getValueAt(row,0).toString());
			//Cr�ation d'un tableau contenant le d�tail du m�dicament
			String[] data = new String[5];
			data[0]=med.getName();
			data[1]=med.getItsForm().getName();
			data[2]=DatesConverter.dateToStringFR(med.getPatentDate());
			data[3]=med.getPrincipeActif().getName();
			data[4]=med.getExcipient().getName();
			//Cr�ation de la vue de modification du m�dicament s�lectionn� dans la jtable
			MedicineChange frame = new MedicineChange(this.formsBox(),data,this.compositionsBox());
			//Assignation d'un observateur sur cette vue
			frame.assignListener(this);
			//Affichage de la vue
			frame.setVisible(true);
		 } 
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
