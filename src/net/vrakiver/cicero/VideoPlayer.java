package net.vrakiver.cicero;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class VideoPlayer {

	private String mediaURL;

	private JPanel panel;

	private JFXPanel jfxPanel;
	private Media media;
	private MediaPlayer player;
	private MediaView mediaView;
	private BorderPane root;
	private Scene scene;
	private CiceroGUI gui;
	private JPanel nextScene;

	// create on AWT Event Dispatch Thread
	public VideoPlayer(URL mediaURL, CiceroGUI gui, JPanel nextScene) {
		this.mediaURL = mediaURL.toString();
		this.gui = gui;
		this.nextScene = nextScene;
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setPreferredSize(new Dimension(1024, 576));
		Platform.setImplicitExit(false);
		showVideo();
	}

	private void showVideo() {

		jfxPanel = new JFXPanel();

		Platform.runLater(new Runnable() {
			public void run() {
				media = new Media(mediaURL);
				player = new MediaPlayer(media);
				player.play();
				mediaView = new MediaView(player);
				mediaView.setFitHeight(576);
				mediaView.setFitWidth(1024);
				root = new BorderPane(mediaView);
				scene = new Scene(root, 1024, 576);
				jfxPanel.setScene(scene);
				player.setOnEndOfMedia(new Runnable() {
					public void run() {
						tearDownVideo();
						gui.nextScene(nextScene);
					}
				});
			}
		});
		panel.add(jfxPanel);
		gui.nextScene(panel);

		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tearDownVideo();
				gui.nextScene(nextScene);
			}
		});
		
		jfxPanel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tearDownVideo();
				gui.nextScene(nextScene);
			}
		});
	}

	private void tearDownVideo() {

		panel.remove(jfxPanel);

		Platform.runLater(new Runnable() {
			public void run() {
				player.stop();
				player.dispose();
				player = null;
				mediaView = null;
				root = null;
				jfxPanel.setScene(null);
				scene = null;
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						jfxPanel = null;
					}
				});
			}
		});
	}
}