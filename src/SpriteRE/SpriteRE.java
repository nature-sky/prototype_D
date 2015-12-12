package SpriteRE;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import DOM.DOM;
import main.Character;
import main.Item;
import main.Sprite;

public class SpriteRE extends JPanel implements ActionListener {
	private Timer timer;
    private final int DELAY = 50;
    private DOM dom;
    private Vector<Sprite> DOMList;
    
    public SpriteRE(DOM dom) {
        initBoard();
        this.dom = dom;
    }
    
    private void initBoard() {
    	addKeyListener(new TAdapter());
        setFocusable(true);
    	
    	DOMList = new Vector<Sprite>();
        timer = new Timer(DELAY,this);
        timer.start();
    }
	
	public void renderSprites() {
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    
	    DOMList = dom.getAllDynamicObjects();
		for(Sprite s : DOMList) {
			if(s instanceof Character) {
				Character person = (Character)s;
				ImageIcon[] showImgs = person.getImages();
				person.setClick(person.getClick() + person.getChange()); // update click status
			    g.drawImage(showImgs[(person.getClick())%4].getImage(), person.getX(), person.getY(), this); 
			}
			
			else if(s instanceof Item) {
				Item item = (Item)s;
				ImageIcon showImg = item.getImage();
				g.drawImage(showImg.getImage(), item.getX(), item.getY(), this); 
			}
	    }
		
	}
	
	private class TAdapter extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			dom.getCharacterMap().get(dom.getClientNo()).keyReleased(e);
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			dom.getCharacterMap().get(dom.getClientNo()).keyPressed(e);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		renderSprites();
	}
	
	public Vector<Sprite> getDOMList() {
		return DOMList;
	}
}
