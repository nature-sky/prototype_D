package main;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main extends JFrame {
	
	public Main() {
		setUI();
	}
	
	public void setUI() {
		setResizable(false);
		add(new Board());
		setTitle("prototype-D-animation");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Main();
			}
		});
	}

}
