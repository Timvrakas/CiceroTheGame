package net.vrakiver.cicero.scene;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import net.vrakiver.cicero.CiceroGUI;

public class EndScene extends JPanel {
	private static final long serialVersionUID = -3265048227811152279L;
	CiceroGUI gui;
	private BufferedImage image;

	public EndScene(CiceroGUI parentGui) {
		super();
		super.setPreferredSize(new Dimension(1024, 768));
		this.gui = parentGui;
		
		
		try {
			image = ImageIO.read(Scene1.class.getResource("/res/end.png"));
		} catch (IOException e1) {
			System.out.println("Could not find resources");
			e1.printStackTrace();
		}

		
		JButton quit = new JButton();
		quit.setOpaque(false);
		quit.setContentAreaFilled(false);
		quit.setBorderPainted(true);
		quit.setBounds(412, 74, 200, 100);
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton newGame = new JButton();
		newGame.setOpaque(false);
		newGame.setContentAreaFilled(false);
		newGame.setBorderPainted(true);
		newGame.setBounds(435, 540, 350, 100);
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.nextScene(new Scene1(gui));
			}
		});

		this.setLayout(null);
		this.add(newGame);
		this.add(quit);

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}
}
