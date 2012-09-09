package com.brick.helper;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class frmSplash {

	private JLabel SplashImage;
	private JLabel SplashText;
	private JWindow window;
	private JPanel panel;

	public frmSplash(int duration) {
		window = new JWindow();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		window.setBounds((screen.width - 490) / 2, (screen.height - 300) / 2,
				400, 300);

		panel = (JPanel) window.getContentPane();
		SplashImage = new JLabel(createImageIcon("images/splash.jpg", "test"));
		SplashText = new JLabel("revol-tech", SwingConstants.CENTER);
		panel.add(SplashImage, BorderLayout.CENTER);
		panel.add(SplashText, BorderLayout.SOUTH);

		window.setVisible(true);
		try {
			Thread.sleep(duration);
		} catch (Exception ex) {
		}// try catch closed
		window.setVisible(false);
		window.dispose();
	}// constructr closed

	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

}// class closed

