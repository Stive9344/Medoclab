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
import java.awt.Color;

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
	private static JComboBox<String> cbxFormes;
	private static JComboBox<String> cbxModes;
	private static JTextField txtBrevet;
	private JTextField textField;
	private JTextField textField_1;

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
	
	public static String getTxtMode(){
		return (String) cbxModes.getSelectedItem();
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
	 */
	public MedicineAdd(String[] forms,String[] modes) {
		setTitle("M\u00E9dicament - Ajouter");
		setModal(true);
		setBounds(100, 100, 450, 423);
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
		cbxFormes.setEditable(true);
		cbxFormes.setBounds(140, 125, 192, 20);
		contentPanel.add(cbxFormes);
		
		JLabel lblDateBrevet = new JLabel("Date brevet :");
		lblDateBrevet.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateBrevet.setBounds(53, 87, 80, 14);
		contentPanel.add(lblDateBrevet);
		
		txtBrevet = new JTextField();
		txtBrevet.setBounds(140, 84, 192, 20);
		contentPanel.add(txtBrevet);
		txtBrevet.setColumns(10);
		
		JLabel lblAdministration = new JLabel("Administration : ");
		lblAdministration.setBounds(42, 159, 114, 14);
		contentPanel.add(lblAdministration);
		
		cbxModes = new JComboBox<String>(modes);
		cbxModes.setEditable(true);
		cbxModes.setBackground(Color.WHITE);
		cbxModes.setBounds(140, 156, 192, 20);
		contentPanel.add(cbxModes);
		
		JLabel lblEffetsIndsirables = new JLabel("Effets ind\u00E9sirables :");
		lblEffetsIndsirables.setBounds(12, 197, 121, 14);
		contentPanel.add(lblEffetsIndsirables);
		
		textField = new JTextField();
		textField.setBounds(140, 194, 192, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblComposition = new JLabel("Composition : ");
		lblComposition.setBounds(53, 239, 91, 14);
		contentPanel.add(lblComposition);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEditable(true);
		comboBox_1.setToolTipText("1");
		comboBox_1.setBounds(140, 236, 50, 20);
		contentPanel.add(comboBox_1);
		
		JLabel lblPrincipeActif = new JLabel("Principe actif : ");
		lblPrincipeActif.setBounds(53, 280, 91, 14);
		contentPanel.add(lblPrincipeActif);
		
		textField_1 = new JTextField();
		textField_1.setBounds(140, 277, 197, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblExcipients = new JLabel("Excipient(s)");
		lblExcipients.setBounds(200, 239, 70, 14);
		contentPanel.add(lblExcipients);
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
