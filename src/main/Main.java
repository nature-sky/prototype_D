package main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import SpriteRE.SpriteRE;
import TCPCM.TCPCM;
import CDC.CDC;
import DOM.DOM;

public class Main extends JFrame {
	
	public Main() {
		setUI();
	}
	
	public void setUI() {
		setResizable(false);
		//add(new Board());
		
		DOM dom;
		CDC cdc = new CDC();
		dom = new DOM(0, new TCPCM());
		dom.setInitLocationMap(cdc.sendInitLocationMap());
		dom.addVirtualCharacter(0);
		dom.addVirtualCharacter(1);
		dom.addItem("butterfly", 5, true, 100, 10);
		dom.addItem("flower", 6, true, 200, 10);
		add(new SpriteRE(dom));
		
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
