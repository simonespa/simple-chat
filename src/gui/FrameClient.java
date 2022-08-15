package gui;

import gui.event.ButtonEventClient;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class FrameClient extends JFrame {

	private JPanel pannello;
	private JTextArea chat;
	private JTextField messaggio;
	private JButton invia;
	
	public JTextField getTextField(){
		return messaggio;
	}
	
	public JTextArea getTextArea(){
		return chat;
	}
	
	public FrameClient(){
		super("Messenger - Disconnesso");
		setProperty();
		addComponent();
		setVisible(true);
	}
	
	private void setProperty(){
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(400,400);
		setLocation(dim.width/2-200, dim.height/2-200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void addComponent(){
		// crea il pannello che viene aggiunto sul frame
		pannello = new JPanel(new BorderLayout());

		// crea una TextArea e la passa al costruttore di uno ScrollPane
		chat = new JTextArea();
		chat.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(chat);

		// crea i restanti componenti
		messaggio = new JTextField();
		invia = new JButton("Invia");
		invia.setMnemonic('I');
		invia.addActionListener(new ButtonEventClient(chat,messaggio));
		
		// aggiunge la TextArea creando un bordo
		JPanel[] pnlFrame = new JPanel[4];
		for( int i = 0; i < 4; i++ ){
			pnlFrame[i] = new JPanel();
		}
		pannello.add(scrollPane);
		pannello.add(pnlFrame[0], BorderLayout.NORTH);
		pannello.add(pnlFrame[1], BorderLayout.SOUTH);
		pannello.add(pnlFrame[2], BorderLayout.WEST);
		pannello.add(pnlFrame[3], BorderLayout.EAST);
		
		// agiunge il TextField e il Button con il bordo
		JPanel pnlSouth = new JPanel(new BorderLayout());
		pnlSouth.add(messaggio,BorderLayout.CENTER);
		pnlSouth.add(invia,BorderLayout.EAST);
		for( int i = 0; i < 4; i++ ){
			pnlFrame[i] = new JPanel();
		}
		pnlSouth.add(pnlFrame[0], BorderLayout.NORTH);
		pnlSouth.add(pnlFrame[1], BorderLayout.SOUTH);
		pnlSouth.add(pnlFrame[2], BorderLayout.WEST);
		pannello.add(pnlSouth, BorderLayout.SOUTH);
		add(pannello);
	}
}