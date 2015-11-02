package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Person extends JPanel implements KeyListener {
	private ImageIcon[] frontImg;
	private ImageIcon[] backImg;
	private ImageIcon[] leftImg;
	private ImageIcon[] rightImg;
	private ImageIcon[] imgs;
	
	private int px;
	private int py;
	
	private int change;
	private int click = 0;
	
	public Person() {
		initPerson();
		//setFocusable(true);
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

		imgs = frontImg;
		px = 170;
		py = 110;
		setLocation(px, py);
		setSize(100, 100);
	}
	
	public ImageIcon[] getImages() {
		return imgs;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP) {
			imgs = backImg;
			change = 1;
		}
		
		if(key == KeyEvent.VK_DOWN) {
			imgs = frontImg;
			change = 1;
		}
		
		if(key == KeyEvent.VK_LEFT) {
			imgs = leftImg;
			change = 1;
		}
		
		if(key == KeyEvent.VK_RIGHT) {
			imgs = rightImg;
			change = 1;
		}
		
		if(key == KeyEvent.VK_SPACE) {
			imgs = frontImg;
			change = 0;
			click = 0;
		}
		
	}

	public void keyReleased(KeyEvent e) {
		change = 0;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	public int getChange() {
		return change;
	}

	public int getClick() {
		return click;
	}
	public void setClick(int i){
		click = i;
	}
}
