package net.vrakiver.cicero.scene;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import net.vrakiver.cicero.CiceroGUI;
import net.vrakiver.cicero.VideoPlayer;

public class Scene4 extends JPanel {
	private static final long serialVersionUID = -3265048227811152279L;
	CiceroGUI gui;
	private BufferedImage image;

	public Scene4(CiceroGUI parentGui) {
		super();
		super.setPreferredSize(new Dimension(1024, 768));
		this.gui = parentGui;

		try {
			image = ImageIO.read(Scene1.class.getResource("/res/4/4.png"));
		} catch (IOException e1) {
			System.out.println("Could not find resources");
			e1.printStackTrace();
		}

		JButton button1 = new JButton();
		button1.setOpaque(false);
		button1.setContentAreaFilled(false);
		button1.setBorderPainted(false);
		button1.setBounds(48, 400, 450, 100);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wrong();
			}
		});
		JButton button2 = new JButton();
		button2.setOpaque(false);
		button2.setContentAreaFilled(false);
		button2.setBorderPainted(false);
		button2.setBounds(536, 400, 375, 100);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VideoPlayer(ClassLoader.getSystemResource("res/battle.mp4"), gui, new EndScene(gui));
			}
		});

		JButton button3 = new JButton();
		button3.setOpaque(false);
		button3.setContentAreaFilled(false);
		button3.setBorderPainted(false);
		button3.setBounds(73, 572, 400, 100);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wrong();
			}
		});

		JButton button4 = new JButton();
		button4.setOpaque(false);
		button4.setContentAreaFilled(false);
		button4.setBorderPainted(false);
		button4.setBounds(536, 572, 375, 100);
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wrong();
			}
		});

		this.setLayout(null);

		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button4);

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}

	private void wrong() {
		try {
			image = ImageIO.read(Scene1.class.getResource("/res/3/wrong.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.repaint();
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				returnImage();
			}
		}, 2000);
	}

	private void returnImage() {
		try {
			image = ImageIO.read(Scene1.class.getResource("/res/3/3.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.repaint();
	}
}
