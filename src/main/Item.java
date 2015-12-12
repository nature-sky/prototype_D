package main;

import java.awt.Image;
import java.util.HashMap;
import javax.swing.ImageIcon;

public class Item extends Sprite {
   private HashMap<Integer, ImageIcon> imageMap;
   private String name;
   private int index;
   private boolean shared;
   private int owner = -1;
   
   public Item(String name, int index, boolean shared) {
	   this.name = name;
	   this.index = index;
	   this.shared = shared;
	   initItem();
   }
   
   public Item(String name, int index, boolean shared, int x, int y) {
	   this.name = name;
	   this.index = index;
	   this.shared = shared;
	   this.x = x;
	   this.y = y;
	   initItem();
   }
   
   private void initItem() {
	   imageMap = new HashMap<Integer, ImageIcon>();
	   String imgLocation = "images/item/";
	   //System.out.println(imgLocation);
	   String[] imgNames = {"5", "6"};
	   String imgExt = ".gif";
	   for(String s : imgNames) {
		  String imgPath = imgLocation + s + imgExt;
		  imageMap.put(Integer.valueOf(s), new ImageIcon(imgPath));
	   }
	   
	   setLocation(x, y);
	   setSize(50, 50);
   }
   
   public Image getImage() {
		return imageMap.get(index).getImage();
   }
   
   public String getName() {
	   return name;
   }
   
   public int getIndex() {
	   return index;
   }
   
   public void setShared(boolean shared) {
	   this.shared = shared;
   }
   
   public boolean getShared() {
	   return shared;
   }
   
   public void setOwner(int owner) {
	   this.owner = owner;
   }
   
   public int getOwner() {
	   return owner;
   }
}
