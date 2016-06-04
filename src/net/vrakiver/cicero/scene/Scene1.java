package net.vrakiver.cicero.scene;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.vrakiver.cicero.CiceroGUI;

public class Scene1 extends JPanel implements Scene{
	private static final long serialVersionUID = 1154083468816440589L;
	CiceroGUI gui;
	
	public Scene1(CiceroGUI gui) {
		super();
		this.gui = gui;

		JButton next = new JButton();
		next.add(new JLabel("Rekt"));

		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.nextScene(new Scene2(gui));
			}
		});

		this.add(new JLabel("Scene1"));
		this.add(next);
	}
}
