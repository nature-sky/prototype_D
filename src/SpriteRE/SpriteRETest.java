package SpriteRE;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sun.awt.image.ToolkitImage;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import main.Item;
import main.Sprite;
import TCPCM.TCPCM;
import CDC.CDC;
import DOM.DOM;

public class SpriteRETest extends JPanel{
	CDC cdcTest = new CDC();
	DOM domTest = new DOM(0, new TCPCM());
	SpriteRE spriteRETest;
	
	@Before
	public void setUp() throws Exception {
		domTest.setInitLocationMap(cdcTest.sendInitLocationMap());
		spriteRETest = new SpriteRE(domTest);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRenderSprites() {
		//domTest.addVirtualCharacter(1);
		domTest.addItem("butterfly", 5, true, 200, 10);
		spriteRETest.renderSprites();
		assertEquals(1, spriteRETest.getDOMList().size());
 		
		BufferedImage expectedImg = null;
		BufferedImage actualImg = null;
		
		for(Sprite s : spriteRETest.getDOMList()) {
			Item target = (Item)s;
			ImageIcon img = new ImageIcon("images/item/5.gif");
			expectedImg = ((ToolkitImage)img.getImage()).getBufferedImage();
			actualImg = ((ToolkitImage)target.getImage()).getBufferedImage();
			compareImages(expectedImg, actualImg);
		}
	}
	
	private void compareImages(BufferedImage expectedImg, BufferedImage actualImg) throws AssertionError {
	    int minX = expectedImg.getMinX();
	    int minY = expectedImg.getMinY();
	    int maxX = expectedImg.getMinX() + expectedImg.getWidth();
	    int maxY = expectedImg.getMinY()+ expectedImg.getHeight();

	    assertEquals(minX, actualImg.getMinX()); 
	    assertEquals(minY, actualImg.getMinY()); 
	    assertEquals(expectedImg.getHeight(), actualImg.getHeight()); 
	    assertEquals(expectedImg.getWidth(), actualImg.getWidth()); 
	    for (int x = minX; x < maxX; x++){
	        for (int y = minY; y < maxY; y++) {
	            assertEquals(expectedImg.getRGB(x, y), actualImg.getRGB(x, y));
	        }
	    }
	}
}
