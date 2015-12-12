package UDPBC;

import java.awt.Point;
import java.util.HashMap;

import main.Item;

public class UDPBC {
	
	public UDPBC() {
		
	}
	
	private HashMap<Integer, Point> initLocationMap;
	private HashMap<Integer, Item> itemInfoMap;
	
	public HashMap<Integer, Point> sendInitLocationMap() {
		return initLocationMap;
	}
	
	public HashMap<Integer, Point> getInitLocationMap() {
		return initLocationMap;
	}
	
	public HashMap<Integer, Item> sendItemInfoMap() {
		return itemInfoMap;
	}
	
	public HashMap<Integer, Item> getItemInfoMap() {
		return itemInfoMap;
	}

}
