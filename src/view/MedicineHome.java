package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Ctrl;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
/**
 * Classe définissant la vue d'accueil des médicaments
 * @author xavier
 *
 */
public class MedicineHome extends JFrame implements MyView{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAjout;
	private JButton btnRechercherModifier;


	/**
	 * Create the frame.
	 */
	public MedicineHome() {
		setTitle("M\u00E9dicament - Accueil");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion des m\u00E9dicaments");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(101, 50, 214, 14);
		contentPane.add(lblNewLabel);
		
		btnAjout = new JButton("Ajouter");
		btnAjout.setBounds(101, 86, 214, 23);
		contentPane.add(btnAjout);
		
		btnRechercherModifier = new JButton("Rechercher / Modifier");
		btnRechercherModifier.setBounds(101, 120, 214, 23);
		contentPane.add(btnRechercherModifier);
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFermer.setBounds(335, 227, 89, 23);
		contentPane.add(btnFermer);
		
		
	}


	@Override
	public void assignListener(Ctrl ctrl) {
		this.btnAjout.setActionCommand("MedicineHome_ajout");
		this.btnAjout.addActionListener(ctrl);
		this.btnRechercherModifier.setActionCommand("MedicineHome_rechercherModifier");
		this.btnRechercherModifier.addActionListener(ctrl);
		
	}
}
