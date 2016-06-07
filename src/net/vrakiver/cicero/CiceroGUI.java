package net.vrakiver.cicero;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.vrakiver.cicero.scene.Scene1;

public class CiceroGUI extends JFrame {
	private static final long serialVersionUID = 3679551879916273308L;
	JPanel page;

	public CiceroGUI() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Cicero Game");
		this.setBackground(Color.BLACK);

		page = new Scene1(this);
		this.add((JPanel) page);
		pack();
		setVisible(true);
	}

	public void nextScene(JPanel nextPage) {
		this.remove(page);
		page = nextPage;
		this.add(page,BorderLayout.CENTER);
		this.validate();
	}

	public static void main(String[] args) {
		new CiceroGUI();
	}
}
