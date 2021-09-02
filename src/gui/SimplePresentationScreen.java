package gui;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalTime;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Image;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JLabel ApellidoLabel;
	private JLabel NombreLabel;
	private JLabel EmailLabel;
	private JLabel GitHubLabel;
	private JTextField LUTextField;
	private JTextField ApellidoTextField;
	private JTextField NombreTextField;
	private JTextField EmailTextField;
	private JTextField GitHubTextField;
	private JLabel TiempoLabel;
	private JLabel FotoLabel;

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(654, 262));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss");
        
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		
		JLabel LULabel = new JLabel("LU");
		
		LUTextField = new JTextField();
		LUTextField.setText(""+ studentData.getId());
		LUTextField.setColumns(10);
		
		ApellidoLabel = new JLabel("Apellido");
		
		ApellidoTextField = new JTextField();
		ApellidoTextField.setText(studentData.getLastName());
		ApellidoTextField.setColumns(10);
		
		NombreLabel = new JLabel("Nombre");
		
		NombreTextField = new JTextField();
		NombreTextField.setText(studentData.getFirstName());
		NombreTextField.setColumns(10);
		
		EmailLabel = new JLabel("Email");
		
		EmailTextField = new JTextField();
		EmailTextField.setText(studentData.getMail());
		EmailTextField.setColumns(10);
		
		GitHubLabel = new JLabel("GitHub URL");
		
		GitHubTextField = new JTextField();
		GitHubTextField.setText(studentData.getGithubURL());
		GitHubTextField.setColumns(10);
		GroupLayout gl_tabInformation = new GroupLayout(tabInformation);
		gl_tabInformation.setHorizontalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING, false)
						.addComponent(GitHubLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(EmailLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(NombreLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ApellidoLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(LULabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(LUTextField, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
						.addComponent(NombreTextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
						.addComponent(GitHubTextField, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
						.addComponent(ApellidoTextField, Alignment.TRAILING)
						.addComponent(EmailTextField))
					.addGap(10))
		);
		gl_tabInformation.setVerticalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(LULabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(LUTextField, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(ApellidoLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(ApellidoTextField, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(NombreLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(NombreTextField, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(EmailLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(EmailTextField, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(GitHubLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(GitHubTextField, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		tabInformation.setLayout(gl_tabInformation);
		contentPane.add(tabbedPane, BorderLayout.WEST);
		
		// pide la fecha y el tiempo local con un formato dd/mm/aaaa y hh:mm:ss y lo muestra debajo de todo en el "sur"
		TiempoLabel = new JLabel("Esta ventana fue generada el "+ LocalDate.now().format(fecha) +" a las " + LocalTime.now().format(hora));
		contentPane.add(TiempoLabel, BorderLayout.SOUTH);
		
		JPanel ImagePanel = new JPanel();
		contentPane.add(ImagePanel, BorderLayout.CENTER);
		ImagePanel.setLayout(null);
		
		//creo el label q contendra la imagen y lo escalo
		FotoLabel = new JLabel("");
		FotoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		FotoLabel.setBounds(0, 5, 210, 206);	
		
		//cambios para q la imagen tenga la misma escala q la label
		ImageIcon imageIcon = new ImageIcon(SimplePresentationScreen.class.getResource(studentData.getPathPhoto()));
		Image imagen = imageIcon.getImage(); //conseguir imagen 
		imagen = imagen.getScaledInstance(FotoLabel.getWidth(), FotoLabel.getHeight(),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(imagen);  //cambiar la imagen del imageIcon
		FotoLabel.setIcon(imageIcon);
		
		//agrego la label al panel
		ImagePanel.add(FotoLabel);

	}
}
