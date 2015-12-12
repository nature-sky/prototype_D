package main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.ImageIcon;

public class Character extends Sprite implements KeyListener {
	
	private ImageIcon[] frontImg;
	private ImageIcon[] backImg;
	private ImageIcon[] leftImg;
	private ImageIcon[] rightImg;
	private ImageIcon[] imgs;
	
	private int dir;
	private int speed;
	private Vector<Item> itemList;
	
	
	private Integer change = 0;
	private Integer click = 0;
	
	public Character() {
		initCharacter();
		addKeyListener(this);
	}
	
	public Character(int dir, int speed, int x, int y) {
		this.dir = dir;
		this.speed = speed;
		this.x = x;
		this.y = y;
		this.itemList = new Vector<Item>();
		initCharacter();
		addKeyListener(this);
	}
	
	private void initCharacter() {
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
		setLocation(x, y);
		setSize(100, 100);
	}
	
	public ImageIcon[] getImages() {
		return imgs;
	}
	
	public void updateVirtualCharacter(int dir, int speed, int x, int y) {
		this.dir = dir;
		this.speed = speed;
		this.x = x;
		this.y = y;
	}
	
	public int getDir() {
		return dir;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public Vector<Item> getItemList() {
		return itemList;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP) {
			imgs = backImg;
			synchronized(this.change) {
				change = 1;
			}
		}
		
		if(key == KeyEvent.VK_DOWN) {
			imgs = frontImg;
			synchronized(this.change) {
				change = 1;
			}
		}
		
		if(key == KeyEvent.VK_LEFT) {
			imgs = leftImg;
			synchronized(this.change) {
				change = 1;
			}
		}
		
		if(key == KeyEvent.VK_RIGHT) {
			imgs = rightImg;
			synchronized(this.change) {
				change = 1;
			}
		}
		
		if(key == KeyEvent.VK_SPACE) {
			imgs = frontImg;
			synchronized(this.change) {
				change = 0;
			}
			synchronized(this.click) {
				click = 0;
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		synchronized(this.change) {
			change = 0;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	public int getChange() {
		synchronized(this.change){
			return change;
		}
	}

	public int getClick() {
		synchronized(this.click) {
			return click;
		}
	}
	public void setClick(int i){
		synchronized(this.click) {
			click = i;
		}
	}
}
