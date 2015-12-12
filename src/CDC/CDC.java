package CDC;

import java.awt.Point;
import java.util.HashMap;

import main.Item;
import main.Character;

public class CDC {
	private HashMap<Integer, Point> initLocationMap;
	private HashMap<Integer, Character> characterMap;
	private HashMap<Integer, Item> itemInfoMap;
	private HashMap<Integer, Item> itemMap;
	
	public CDC() {
		initLocationMap = new HashMap<Integer, Point>();
		initLocationMap.put(0, new Point(10, 10));
		initLocationMap.put(1, new Point(150, 10));
		initLocationMap.put(2, new Point(150, 150));
		initLocationMap.put(3, new Point(10, 150));
		characterMap = new HashMap<Integer, Character>();
		
		itemInfoMap = new HashMap<Integer, Item>();
		itemInfoMap.put(5, new Item("butterfly", 5, true, 100, 10));
		itemInfoMap.put(6, new Item("flower", 6, true, 200, 10));
		itemInfoMap.put(7, new Item("cat", 7, false, 200, 200));
		itemInfoMap.put(8, new Item("dog", 8, false, 100, 200));
		itemMap = new HashMap<Integer, Item>();
	}
	
	public void addVirtualCharcter(int clientno) {
		characterMap.put(clientno, new Character(0, 0, 
				(int)(initLocationMap.get(clientno).getX()), (int)(initLocationMap.get(clientno).getY())));
	}
	
	public void additem(String name, int index, boolean shared, int x, int y) {
	    itemMap.put(index, new Item(name, index, shared, x, y));
    }
	
	public HashMap<Integer, Point> sendInitLocationMap() {
		return initLocationMap;
	}
	
	public HashMap<Integer, Item> sendItemInfoMap() {
		return itemInfoMap;
	}
}
