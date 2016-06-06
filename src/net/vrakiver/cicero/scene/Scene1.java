package net.vrakiver.cicero.scene;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import net.vrakiver.cicero.CiceroGUI;

public class Scene1 extends JPanel implements Scene {
	private static final long serialVersionUID = 1154083468816440589L;
	CiceroGUI gui;
	private BufferedImage image;
	private float fade = 1;
	private Timer timer = new Timer();

	public Scene1(CiceroGUI gui) {
		super();
		super.setPreferredSize(new Dimension(1024, 768));
		this.gui = gui;
		try {
			image = ImageIO.read(new File("media/1/1.png"));
		} catch (IOException e1) {
			System.out.println("Could not find resources");
			e1.printStackTrace();
		}

		

		JButton next = new JButton();
		next.setOpaque(false);
		next.setContentAreaFilled(false);
		next.setBorderPainted(false);
		next.setBounds(40, 450, 300, 130);
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});

		JButton quit = new JButton();
		quit.setOpaque(false);
		quit.setContentAreaFilled(false);
		quit.setBorderPainted(false);
		quit.setBounds(690, 450, 300, 130);
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		this.setLayout(null);
		this.add(quit);
		this.add(next);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN, fade));
		g2d.setPaint(Color.BLACK);
		g2d.drawImage(image, 0, 0, null);
	}

	private void next() {
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				fade -= 0.01;
				repaint();
				if(fade <= 0.01){
					timer.cancel();
					gui.nextScene(new Scene2(gui));
				}
			}
		}, 0, 8);

	}
}
