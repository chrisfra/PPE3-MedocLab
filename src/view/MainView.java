package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Ctrl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Classe définissant la vue générale de l'application
 * @author xavier
 *
 */
public class MainView extends JFrame implements MyView{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnManuel;

	/**
	 * Launch the application.
	 * @param args arguments du main
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Création du contrôleur
					Ctrl ctrl = new Ctrl();
					//Création de la vue générale
					MainView frame = new MainView();
					//Assignation d'un observateur sur cette vue
					frame.assignListener(ctrl);
					//Affichage de la vue
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		setTitle("MedocLab - Accueil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnManuel = new JButton("Gestion des m\u00E9dicaments");
		btnManuel.setBounds(54, 56, 309, 23);
		contentPane.add(btnManuel);
		
		JButton btnFermer = new JButton("Quitter");
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnFermer.setBounds(335, 227, 89, 23);
		contentPane.add(btnFermer);
	}

	@Override
	public void assignListener(Ctrl ctrl) {
		this.btnManuel.setActionCommand("MainView_manuel");
		this.btnManuel.addActionListener(ctrl);		
	}
}
