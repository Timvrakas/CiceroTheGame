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

public class Scene3 extends JPanel {
	private static final long serialVersionUID = -3265048227811152279L;
	CiceroGUI gui;
	private BufferedImage image;

	public Scene3(CiceroGUI parentGui) {
		super();
		super.setPreferredSize(new Dimension(1024, 768));
		this.gui = parentGui;

		try {
			image = ImageIO.read(Scene1.class.getResource("/res/3/3.png"));
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
				wrong();
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

		JButton all = new JButton();
		all.setOpaque(false);
		all.setContentAreaFilled(false);
		all.setBorderPainted(false);
		all.setBounds(536, 572, 375, 100);
		all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.nextScene(new Scene4(gui));
			}
		});

		this.setLayout(null);

		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(all);

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
