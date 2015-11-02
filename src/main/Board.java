package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Person person;
    private final int DELAY = 50;

    public Board() {
        initBoard();
    }
    
    private void initBoard() {
        addKeyListener(new TAdapter());
        setFocusable(true);

        person = new Person();
        timer = new Timer(DELAY,this);
        timer.start();
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        ImageIcon[] showImgs = person.getImages();
        person.setClick(person.getClick()+person.getChange()); // update click status
        g2d.drawImage(showImgs[(person.getClick())%4].getImage(), person.getX(), person.getY(), this); 
        Toolkit.getDefaultToolkit().sync();
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            person.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            person.keyPressed(e);
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}
