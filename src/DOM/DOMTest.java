package DOM;

import static org.junit.Assert.*;
import java.awt.Point;
import main.Character;
import main.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import CDC.CDC;
import TCPCM.TCPCM;

public class DOMTest {
	DOM domTest;
	CDC cdcTest = new CDC();
	//UDPBC udpbcTest = new UDPBC();
	//UDPUS udpusTest = new UDPUS(domTest);
	int clientno = 0;

	@Before
	public void setUp() throws Exception {
		domTest = new DOM(clientno, new TCPCM());
		domTest.setInitLocationMap(cdcTest.sendInitLocationMap());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddVirtualCharacter() {
		domTest.addVirtualCharacter(1);
		assertEquals(1, domTest.getCharacterMap().size());
		Character c = domTest.getCharacterMap().get(1);
		assertEquals(0, c.getDir());
   	    assertEquals(0, c.getSpeed());
   	    assertEquals(150, (int)c.getX());
   	    assertEquals(10, (int)c.getY());
	}

	@Test
	public void testAddItem() {
		domTest.addItem("butterfly", 5, true, 100, 10);
		assertEquals(1, domTest.getItemMap().size());
		
		Item i = domTest.getItemMap().get(5);
		assertEquals("butterfly", i.getName());
		assertEquals(5, i.getIndex());
		assertEquals(true, i.getShared());
		assertEquals(100, i.getX());
		assertEquals(10, i.getY());
	}

	@Test
	public void testUpdateVirtualCharacter() {
		domTest.addVirtualCharacter(2);
		Character c = domTest.getCharacterMap().get(2);
		assertEquals(0, c.getDir());
		assertEquals(0, c.getSpeed());
		assertEquals(150, c.getX());
		assertEquals(150, c.getY());
		
		domTest.updateVirtualCharacter(2, 2, 10, 20, 30);
		assertEquals(2, c.getDir());
		assertEquals(10, c.getSpeed());
		assertEquals(20, c.getX());
		assertEquals(30, c.getY());
	}

	@Test
	public void testUpdateItem() {
		domTest.addVirtualCharacter(0);
		domTest.addVirtualCharacter(1);
		
		domTest.addItem("flower", 6, true, 200, 10);
		Item i = domTest.getItemMap().get(6);
		assertEquals("flower", i.getName());
		assertEquals(6, i.getIndex());
		assertEquals(true, i.getShared());
		assertEquals(-1, i.getOwner());
		assertEquals(200, i.getX());
		assertEquals(10, i.getY());
		
		domTest.updateItem(6, false, 0, 250, 50);
		assertEquals("flower", i.getName());
		assertEquals(6, i.getIndex());
		assertEquals(false, i.getShared());
		assertEquals(0, i.getOwner());
		assertEquals(1, domTest.getCharacterMap().get(0).getItemList().size());
		assertEquals(250, i.getX());
		assertEquals(50, i.getY());
		
		domTest.updateItem(6, true, 1, 300, 100);
		assertEquals("flower", i.getName());
		assertEquals(6, i.getIndex());
		assertEquals(true, i.getShared());
		assertEquals(1, i.getOwner());
		assertEquals(0, domTest.getCharacterMap().get(0).getItemList().size());
		assertEquals(1, domTest.getCharacterMap().get(1).getItemList().size());
		assertEquals(300, i.getX());
		assertEquals(100, i.getY());
	}

	@Test
	public void testGetAllDynamicObjects() {
		domTest.addVirtualCharacter(2);
		domTest.addVirtualCharacter(3);
		domTest.addItem("butterfly", 5, false, 100, 10);
		assertEquals(3, domTest.getCharacterMap().size() + domTest.getItemMap().size());
	}

	@Test
	public void testGetVirtualCharacterXY() {
		domTest.addVirtualCharacter(clientno);
		assertEquals(new Point(10,10), domTest.getVirtualCharacterXY());
		
		domTest.updateVirtualCharacter(clientno, 0, 0, 30, 20);
		assertEquals(new Point(30,20), domTest.getVirtualCharacterXY());
	}

	@Test
	public void testKeyGETPressed() {
		domTest.addVirtualCharacter(clientno);
		domTest.addItem("butterfly", 5, true, 100, 10);
		domTest.addItem("flower", 6, true, 200, 10);   
		
		domTest.updateVirtualCharacter(clientno, 2, 10, 0, 10);
		domTest.keyGETPressed();
		assertEquals(-1, domTest.getTCPCM().getMoveCode());
		
		domTest.updateVirtualCharacter(clientno, 2, 10, 99, 10);
		domTest.keyGETPressed();
		assertEquals(4, domTest.getTCPCM().getMoveCode());
		
		domTest.updateVirtualCharacter(clientno, 2, 10, 200, 10);
		domTest.keyGETPressed();
		assertEquals(4, domTest.getTCPCM().getMoveCode());
	}
}
