package tribanco.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import tribanco.dominio.LeitorArquivoEntrada;
import tribanco.dominio.Parametros;

@SuppressWarnings({ "serial", "unused" })
public class Inicial extends JFrame {

	private JPanel contentPane;
	File selFile;
	String filenameEntrada = File.separator + "tmp";
	JFileChooser fcEntrada = new JFileChooser(new File(filenameEntrada));

	JFileChooser seletorDestino = new JFileChooser();

	@SuppressWarnings("rawtypes")
	JComboBox comboBoxLayout = new JComboBox();

	@SuppressWarnings("rawtypes")
	JComboBox comboBoxFormato = new JComboBox();

	JButton btnSelecioneAPasta = new JButton("Selecione a pasta de destino");
	Parametros parametros = new Parametros();

	JButton btnConverter = new JButton("Converter");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicial frame = new Inicial();

					try {
						for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
							if ("Nimbus".equals(info.getName())) {
								UIManager.setLookAndFeel(info.getClassName());
								break;
							}
						}
					} catch (UnsupportedLookAndFeelException e) {
						// handle exception
					} catch (ClassNotFoundException e) {
						// handle exception
					} catch (InstantiationException e) {
						// handle exception
					} catch (IllegalAccessException e) {
						// handle exception
					}

					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Inicial() {
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Inicial.class.getResource("/Assets/planet-earth-1457453_960_720.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 352);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 595, 280);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton arquivoEntrada = new JButton("Selecione o arquivo de entrada");
		arquivoEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Show open dialog
				fcEntrada.showOpenDialog(null);
				//JMJR
				fcEntrada.setCurrentDirectory(new java.io.File("C:\\Users\\julimar.miranda\\Documents\\Teste SGP\\arquivos\\"));

				selFile = fcEntrada.getSelectedFile();
				System.out.println(selFile.getPath());

				btnSelecioneAPasta.setEnabled(true);

			}
		});
		arquivoEntrada.setFont(new Font("Courier New", Font.BOLD, 12));
		arquivoEntrada.setBounds(10, 11, 575, 40);
		panel.add(arquivoEntrada);

		btnSelecioneAPasta.setEnabled(false);
		btnSelecioneAPasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// seletorDestino.setCurrentDirectory(new java.io.File("C:\\Users"));
				
				//
				seletorDestino.setDialogTitle("Pasta Destino");
				seletorDestino.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				seletorDestino.setAcceptAllFileFilterUsed(false);

				comboBoxLayout.setEnabled(true);

				if (seletorDestino.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					System.out.println("getCurrentDirectory(): " + seletorDestino.getCurrentDirectory());
					System.out.println("getSelectedFile() : " + seletorDestino.getSelectedFile());
				} else {
					System.out.println("No Selection ");
				}

			}
		});
		btnSelecioneAPasta.setFont(new Font("Courier New", Font.BOLD, 12));
		btnSelecioneAPasta.setBounds(10, 62, 575, 40);
		panel.add(btnSelecioneAPasta);

		JLabel label = new JLabel("Selecione o Layout desejado:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Courier New", Font.BOLD, 12));
		label.setBounds(10, 113, 575, 20);
		panel.add(label);
		comboBoxLayout.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				comboBoxFormato.setEnabled(true);
			}
		});
		comboBoxLayout.setEnabled(false);

		comboBoxLayout
				.setModel(new DefaultComboBoxModel(new String[] { "Arquivo agenda", "IFP cadastral", "xxx xxxx" }));
		comboBoxLayout.setBounds(10, 133, 575, 20);
		panel.add(comboBoxLayout);

		JLabel lblSelecioneOFormato = new JLabel("Selecione o Formato desejado:");
		lblSelecioneOFormato.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelecioneOFormato.setFont(new Font("Courier New", Font.BOLD, 12));
		lblSelecioneOFormato.setBounds(10, 164, 575, 20);
		panel.add(lblSelecioneOFormato);
		comboBoxFormato.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				btnConverter.setEnabled(true);

			}
		});
		comboBoxFormato.setEnabled(false);

		comboBoxFormato.setModel(new DefaultComboBoxModel(new String[] { "CSV", "XLS", "XML", "JSON" }));
		comboBoxFormato.setBounds(10, 195, 575, 20);
		panel.add(comboBoxFormato);

		btnConverter.setEnabled(false);
		btnConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				parametros.setPathArquivo(selFile.getPath());
				parametros.setNomeArquivo(selFile.getName());
				System.out.println("nome arq:"+selFile.getName());
				parametros.setDirDestino(seletorDestino.getSelectedFile() + "");

				LeitorArquivoEntrada leitor = new LeitorArquivoEntrada();

				try {
					leitor.lerArquivo(parametros);
					JOptionPane.showMessageDialog(null, "Arquivo convertido! #Aleluia lol");	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnConverter.setBounds(435, 226, 150, 40);
		panel.add(btnConverter);

	}
}
