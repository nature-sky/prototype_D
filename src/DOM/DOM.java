package DOM;

import java.awt.Point;
import java.util.HashMap;
import java.util.Vector;

import TCPCM.TCPCM;
import main.Character;
import main.Item;
import main.Sprite;

public class DOM {
	private int clientno;
	private TCPCM tcpcm;
	private HashMap<Integer, Point> initLocationMap;
	private HashMap<Integer, Character> characterMap;
	private HashMap<Integer, Item> itemMap;
    
	public DOM(int clientno, TCPCM tcpcm) {
		this.clientno = clientno;
		this.tcpcm = tcpcm;
		this.initLocationMap = new HashMap<Integer, Point>();
		this.characterMap = new HashMap<Integer, Character>();
		this.itemMap = new HashMap<Integer, Item>();
	}
	
	public void addVirtualCharacter(int clientno) {
		characterMap.put(clientno, new Character(0, 0, 
				         (int)(initLocationMap.get(clientno).getX()), 
				         (int)(initLocationMap.get(clientno).getY())));
    }
  
    public void addItem(String name, int index, boolean shared, int x, int y) {
	    itemMap.put(index, new Item(name, index, shared, x, y));
    }
  
    public void updateVirtualCharacter(int clientno, int dir, int speed, int x, int y) {
 	    characterMap.get(clientno).updateVirtualCharacter(dir, speed, x, y);
    }
  
    public void updateItem(int index, boolean shared, int owner, int x, int y) {
    	Item target = itemMap.get(index);
    	if(target.getOwner() != -1) {
    		 int oldOwner = target.getOwner();
    		 characterMap.get(oldOwner).getItemList().remove(target);
		}
    	
    	target.setShared(shared);
    	target.setOwner(owner);
    	target.setX(x);
    	target.setY(y);
    	characterMap.get(owner).getItemList().add(target);	  
    }
  
    public Vector<Sprite> getAllDynamicObjects() {
	    Vector<Sprite> returnList = new Vector<Sprite>();
	    for(Character c : characterMap.values())
	    	returnList.add(c);
	    for(Item i : itemMap.values())
	    	returnList.add(i);
	    return returnList; 
    }
  
    public Point getVirtualCharacterXY() {
    	return new Point(characterMap.get(clientno).getX(), 
    			         characterMap.get(clientno).getY());
    }
    
    public void keyGETPressed() {
    	int itemX;
    	int itemY; 
    	int characterX = 0;
		int characterY = 0;
    	double distance = 0;
    	
    	for(Integer i : itemMap.keySet()) {
    		itemX = itemMap.get(i).getX();
    		itemY = itemMap.get(i).getY();
    		
    		Point current = getVirtualCharacterXY();
    		characterX = (int)current.getX();
		    characterY = (int)current.getY();
    		distance = Math.sqrt(Math.pow(characterX - itemX, 2) + 
    				             Math.pow(characterY - itemY, 2));
    		
    		if(distance <= 1.0)
    			tcpcm.inputMoves(TCPCM.Keys.GET.ordinal());
    	}
    }
    
    public HashMap<Integer, Character> getCharacterMap() {
    	return characterMap;
    }
    
    public HashMap<Integer, Item> getItemMap() {
    	return itemMap;
    }
    
    public void setInitLocationMap(HashMap<Integer, Point> initLocationMap) {
    	this.initLocationMap = initLocationMap;
    }
    
    public int getClientNo() {
    	return clientno;
    }
    
    public TCPCM getTCPCM() {
        return tcpcm;	
    }
}
