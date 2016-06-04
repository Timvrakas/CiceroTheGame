package net.vrakiver.cicero.scene;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.vrakiver.cicero.CiceroGUI;

public class Scene2 extends JPanel implements Scene{
	
	private static final long serialVersionUID = 4460363807635911710L;
	CiceroGUI gui;

	public Scene2(CiceroGUI gui) {
		super();
		this.gui = gui;

		JButton next = new JButton();
		next.add(new JLabel("Rekt"));

		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//gui.nextScene();
			}
		});

		this.add(new JLabel("Scene2"));
		this.add(next);
	}
}
