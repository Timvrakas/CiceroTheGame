package net.vrakiver.cicero.scene;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import net.vrakiver.cicero.CiceroGUI;
import net.vrakiver.cicero.VideoPlayer;

public class Scene2 extends JPanel {
	private static final long serialVersionUID = -3265048227811152279L;
	CiceroGUI gui;
	private BufferedImage image;

	public Scene2(CiceroGUI parentGui) {
		super();
		super.setPreferredSize(new Dimension(1024, 768));
		this.gui = parentGui;

		try {
			image = ImageIO.read(new File("media/2/2.png"));
		} catch (IOException e1) {
			System.out.println("Could not find resources");
			e1.printStackTrace();
		}

		JButton flee = new JButton();
		flee.setOpaque(false);
		flee.setContentAreaFilled(false);
		flee.setBorderPainted(false);
		flee.setBounds(583, 30, 350, 100);
		flee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VideoPlayer(new File("media/flee.mp4").toURI(), gui, new EndScene(gui));
			}
		});

		JButton kill = new JButton();
		kill.setOpaque(false);
		kill.setContentAreaFilled(false);
		kill.setBorderPainted(false);
		kill.setBounds(583, 193, 350, 150);
		kill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VideoPlayer(new File("media/murder.mp4").toURI(), gui, new EndScene(gui));
			}
		});

		JButton orate = new JButton();
		orate.setOpaque(false);
		orate.setContentAreaFilled(false);
		orate.setBorderPainted(false);
		orate.setBounds(583, 406, 350, 100);
		orate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// gui.nextScene(new Scene3(gui));
			}
		});

		this.setLayout(null);
		this.add(orate);
		this.add(kill);
		this.add(flee);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}
}
