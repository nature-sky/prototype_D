package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Person extends JPanel implements KeyListener{
	private ImageIcon[] frontImg;
	private ImageIcon[] backImg;
	private ImageIcon[] leftImg;
	private ImageIcon[] rightImg;
	private Image img;
	private int px;
	private int py;
	
	public Person() {
		initPerson();
		setFocusable(true);
		addKeyListener(this);
	}
	
	private void initPerson() {
		frontImg = new ImageIcon[4];
		String imgLocation = "images/front/";
		//System.out.println(imgLocation);
		String[] imgNames = {"1", "2", "3", "4"};
		String imgExt = ".png";
		for(int i = 0; i < imgNames.length; i++) {
			String imgPath = imgLocation + imgNames[i] + imgExt;
			frontImg[i] = new ImageIcon(imgPath);
		}
	
		backImg = new ImageIcon[4];
		imgLocation = "images/back/";
		for(int i = 0; i < imgNames.length; i++) {
			String imgPath = imgLocation + imgNames[i] + imgExt;
			backImg[i] = new ImageIcon(imgPath);
		}
		
		leftImg = new ImageIcon[4];
		imgLocation = "images/left/";
		for(int i = 0; i < imgNames.length; i++) {
			String imgPath = imgLocation + imgNames[i] + imgExt;
			leftImg[i] = new ImageIcon(imgPath);
		}
		
		rightImg = new ImageIcon[4];
		imgLocation = "images/right/";
		for(int i = 0; i < imgNames.length; i++) {
			String imgPath = imgLocation + imgNames[i] + imgExt;
			rightImg[i] = new ImageIcon(imgPath);
		}

		img = frontImg[0].getImage();
		px = 165;
		py = 100;
		setLocation(px, py);
		setSize(100, 100);
	}
	
	public Image getImage() {
		return img;
	}
	
	private int click=0;
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP) {
			img = backImg[(click++)%4].getImage();
		}
		
		if(key == KeyEvent.VK_DOWN) {
			img = frontImg[(click++)%4].getImage();
		}
		
		if(key == KeyEvent.VK_LEFT) {
			img = leftImg[(click++)%4].getImage();
		}
		
		if(key == KeyEvent.VK_RIGHT) {
			img = rightImg[(click++)%4].getImage();
		}
		
		if(key == KeyEvent.VK_SPACE) {
			//System.out.println("SPACE");
			img = frontImg[0].getImage();
		}
		repaint();
	}

	public void keyReleased(KeyEvent e) {
	}
	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
	}
}
