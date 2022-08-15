package gui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import chat.Client;

public class ButtonEventClient implements ActionListener {

	private JTextField txtF;
	private JTextArea txtA;
	
	public ButtonEventClient( JTextArea a, JTextField f ){
		txtF = f;
		txtA = a;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = txtF.getText();
		txtF.setText("");
		txtA.append(msg+"\n");
	}
}
