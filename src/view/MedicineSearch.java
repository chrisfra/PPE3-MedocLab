package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.Ctrl;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Classe définissant la vue de recherche d'un médicament
 * @author xavier
 *
 */
public class MedicineSearch extends JDialog implements MyView{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static JTable tableMed;
	
	/**
	 * Méthode permettant de mettre à jour le contenu de la table
	 * @param dataTable le contenu de la table
	 * @param columnsTable le nom des colonnes de la table
	 */
	public static void setTable(String[][] dataTable, String[] columnsTable){
		DefaultTableModel model = new DefaultTableModel(dataTable, columnsTable);
		tableMed.setModel(model);
	}

	/**
	 * Create the dialog.
	 * @param dataTable le contenu de la table
	 * @param columnsTable le nom des colonnes de la table
	 */
	public MedicineSearch(String[][] dataTable, String[] columnsTable) {
		setTitle("M\u00E9dicament - Rechercher");
		setModal(true);
		setBounds(100, 100, 700, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 700, 300);
			contentPanel.add(scrollPane);
			{
				tableMed = new JTable();
				tableMed.setEnabled(false);
				setTable(dataTable, columnsTable);
				scrollPane.setViewportView(tableMed);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
		MedicineSearch.tableMed.addMouseListener(ctrl);	
	}
}
