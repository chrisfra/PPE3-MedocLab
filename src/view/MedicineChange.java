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
 * Classe définissant la vue de modification d'un médicament
 * @author xavier
 *
 */
public class MedicineChange extends JDialog implements MyView{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnValider;
	public static JButton btnAnnuler;
	private static JTextField txtNom;
	private static JComboBox<String> cbxFormes, cbxCompositionsPrincipeActif, cbxCompositionsExicipient;
	private static JTextField txtBrevet;
	/**
	 * Méthode statique permettant d'obtenir le contenu du champ texte nom
	 * @return le contenu du champ texte nom
	 */
	public static String getTxtName(){
		return txtNom.getText();
	}
	/**
	 * Méthode statique permettant d'obtenir la sélection de la liste déroulante forme
	 * @return la selection de la liste déroulante forme
	 */
	public static String getTxtForm(){
		return (String) cbxFormes.getSelectedItem();
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
	 * Create the dialog.
	 * @param forms les formes à intégrer dans la liste déroulante
	 * @param medicine le détail du médicament à modifier
	 */
	public MedicineChange(String[] forms, String[] medicine, String[] compositions) {
		setTitle("M\u00E9dicament - Modifier");
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
		txtNom.setEnabled(false);
		txtNom.setBounds(140, 42, 192, 20);
		contentPanel.add(txtNom);
		txtNom.setColumns(10);
		txtNom.setText(medicine[0]);
		
		JLabel lblForme = new JLabel("Forme :");
		lblForme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblForme.setBounds(63, 127, 70, 14);
		contentPanel.add(lblForme);
		
		cbxFormes = new JComboBox<String>(forms);
		cbxFormes.setBounds(140, 124, 192, 20);
		contentPanel.add(cbxFormes);
		cbxFormes.setSelectedItem(medicine[1]);
		
		JLabel lblDateBrevet = new JLabel("Date brevet :");
		lblDateBrevet.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateBrevet.setBounds(53, 86, 80, 14);
		contentPanel.add(lblDateBrevet);
		
		JLabel lblComposition_PrincipeActif = new JLabel("Principe actif :");
		lblComposition_PrincipeActif.setHorizontalAlignment(SwingConstants.RIGHT);
		lblComposition_PrincipeActif.setBounds(43, 160, 90, 14);
		contentPanel.add(lblComposition_PrincipeActif);
		cbxCompositionsPrincipeActif = new JComboBox<String>(compositions);
		cbxCompositionsPrincipeActif.setBounds(140, 157, 192, 20);
		cbxCompositionsPrincipeActif.setSelectedItem(medicine[3]);
		contentPanel.add(cbxCompositionsPrincipeActif);
		
		JLabel lblComposition_Excipient = new JLabel("Excipient :");
		lblComposition_Excipient.setHorizontalAlignment(SwingConstants.RIGHT);
		lblComposition_Excipient.setBounds(52, 190, 80, 14);
		contentPanel.add(lblComposition_Excipient);
		cbxCompositionsExicipient = new JComboBox<String>(compositions);
		cbxCompositionsExicipient.setBounds(140, 187, 192, 20);
		cbxCompositionsExicipient.setSelectedItem(medicine[4]);
		contentPanel.add(cbxCompositionsExicipient);
		
		txtBrevet = new JTextField();
		txtBrevet.setBounds(140, 83, 192, 20);
		contentPanel.add(txtBrevet);
		txtBrevet.setColumns(10);
		txtBrevet.setText(medicine[2]);
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
				btnAnnuler.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				buttonPane.add(btnAnnuler);
			}
		}
	}


	@Override
	public void assignListener(Ctrl ctrl) {
		this.btnValider.setActionCommand("MedicineChange_valider");
		this.btnValider.addActionListener(ctrl);
	}
}
