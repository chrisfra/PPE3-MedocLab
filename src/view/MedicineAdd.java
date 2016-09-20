package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Ctrl;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

/**
 * Classe définissant la vue d'ajout d'un médicament
 * @author xavier
 *
 */
public class MedicineAdd extends JDialog implements MyView{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnValider;
	private JButton btnAnnuler;
	private static JTextField txtNom;
	private static JComboBox<String> cbxFormes, cbxCompositionsPrincipeActif, cbxCompositionsExicipient;
	private static JTextField txtBrevet;

	/**
	 * Méthode statique permettant de réinitialiser les champs
	 */
	public static void init(){
		txtBrevet.setText("");
		txtNom.setText("");
	}
	
	/**
	 * Méthode statique permettant d'obtenir le contenu du champ texte nom
	 * @return le contenu du champ texte nom
	 */
	public static String getTxtName(){
		return txtNom.getText();
	}
	
	/**
	 * Méthode statique permettant d'obtenir la sélection de la liste déroulante formes
	 * @return la selection de la liste déroulante formes
	 */
	public static String getTxtForm(){
		return (String) cbxFormes.getSelectedItem();
	}
	
	/**
	 * Méthodes statique permettant d'obtenir la sélection de la liste déroulante compositions
	 * @return la selection de la liste déroulante des compositions
	 */
	public static String getTxtComposition_PrincipeActif(){
		return (String) cbxCompositionsPrincipeActif.getSelectedItem();
	}
	
	public static String getTxtComposition_Exicipient(){
		return (String) cbxCompositionsExicipient.getSelectedItem();
	}
	
	/**
	 * Méthode statique permettant d'obtenir le contenu du champ texte date brevet
	 * @return le contenu du champ texte date brevet
	 */
	public static String getTxtPatentDate(){
		if(txtBrevet.getText().equals(""))
			return null;
		return txtBrevet.getText();
	}
	/**
	 * Méthode statique permettant de placer le curseur dans le champ texte nom
	 */
	public static void focusTxtName(){
		MedicineAdd.txtNom.requestFocus();
	}
	
	/**
	 * Create the dialog.
	 * @param forms les formes à intégrer dans la liste déroulante
	 * @params compositions les compositions à intégrer dans les listes déroulante
	 */
	public MedicineAdd(String[] forms, String[] compositions) {
		setTitle("M\u00E9dicament - Ajouter");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNom.setBounds(83, 45, 50, 14);
		contentPanel.add(lblNom);
		
		txtNom = new JTextField();
		txtNom.setBounds(140, 42, 192, 20);
		contentPanel.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblForme = new JLabel("Forme :");
		lblForme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblForme.setBounds(63, 128, 70, 14);
		contentPanel.add(lblForme);
		
		cbxFormes = new JComboBox<String>(forms);
		cbxFormes.setBounds(140, 125, 192, 20);
		contentPanel.add(cbxFormes);
		
		JLabel lblComposition_PrincipeActif = new JLabel("Principe actif :");
		lblComposition_PrincipeActif.setHorizontalAlignment(SwingConstants.RIGHT);
		lblComposition_PrincipeActif.setBounds(43, 160, 90, 14);
		contentPanel.add(lblComposition_PrincipeActif);
		cbxCompositionsPrincipeActif = new JComboBox<String>(compositions);
		cbxCompositionsPrincipeActif.setBounds(140, 157, 192, 20);
		contentPanel.add(cbxCompositionsPrincipeActif);
		
		JLabel lblComposition_Excipient = new JLabel("Excipient :");
		lblComposition_Excipient.setHorizontalAlignment(SwingConstants.RIGHT);
		lblComposition_Excipient.setBounds(52, 190, 80, 14);
		contentPanel.add(lblComposition_Excipient);
		cbxCompositionsExicipient = new JComboBox<String>(compositions);
		cbxCompositionsExicipient.setBounds(140, 187, 192, 20);
		contentPanel.add(cbxCompositionsExicipient);
		
		JLabel lblDateBrevet = new JLabel("Date brevet :");
		lblDateBrevet.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateBrevet.setBounds(53, 87, 80, 14);
		contentPanel.add(lblDateBrevet);
		
		txtBrevet = new JTextField();
		txtBrevet.setBounds(140, 84, 192, 20);
		contentPanel.add(txtBrevet);
		txtBrevet.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnValider = new JButton("Valider");
				buttonPane.add(btnValider);
				getRootPane().setDefaultButton(btnValider);
			}
			{
				btnAnnuler = new JButton("Annuler");
				buttonPane.add(btnAnnuler);
			}
			{
				JButton btnFermer = new JButton("Fermer");
				btnFermer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(btnFermer);
			}
		}
	}


	@Override
	public void assignListener(Ctrl ctrl) {
		this.btnValider.setActionCommand("MedicineAdd_valider");
		this.btnValider.addActionListener(ctrl);
		this.btnAnnuler.setActionCommand("MedicineAdd_annuler");
		this.btnAnnuler.addActionListener(ctrl);
	}
}
