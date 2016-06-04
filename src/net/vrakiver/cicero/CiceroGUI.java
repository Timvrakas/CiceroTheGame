package net.vrakiver.cicero;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.vrakiver.cicero.scene.Scene;
import net.vrakiver.cicero.scene.Scene1;

public class CiceroGUI extends JFrame {
	private static final long serialVersionUID = 3679551879916273308L;
	Scene page;
	
	public CiceroGUI() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Cicero Game");
		setSize(640, 400);
		page = new Scene1(this);
		this.add((JPanel)page);
		setVisible(true);
	}
	
	public void nextScene(Scene nextPage){
		this.remove((JPanel)page);
		page = nextPage;
		this.add((JPanel)page);
		this.validate();
	}	
	
	public static void main(String[] args) {
		new CiceroGUI();
	}

}
