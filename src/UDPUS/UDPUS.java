package UDPUS;

import java.awt.Point;
import java.util.HashMap;

import main.Item;
import DOM.DOM;

public class UDPUS {
	private DOM dom;
	private HashMap<Integer, Point> initLocationMap;
	private HashMap<Integer, Item> itemInfoMap;
	
	public UDPUS(DOM dom) {
		this.dom = dom;
	}
	
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
