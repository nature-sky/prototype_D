package main;

import javax.swing.JFrame;

public class Main extends JFrame {
	
	public Main() {
		setUI();
	}
	
	public void setUI() {
		setLayout(null);
		add(new Person());
		setTitle("prototype-D-animation");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}

}
