package SpriteRE;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import main.Item;
import main.Sprite;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import TCPCM.TCPCM;
import CDC.CDC;
import DOM.DOM;

public class SpriteRETest {
	CDC cdcTest = new CDC();
	DOM domTest = new DOM(0, new TCPCM());
	SpriteRE spriteRETest;
	
	@Before
	public void setUp() throws Exception {
		domTest.setInitLocationMap(cdcTest.sendInitLocationMap());
		domTest.setItemInfoMap(cdcTest.sendItemInfoMap());
		spriteRETest = new SpriteRE(domTest);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRenderSprites() {
		domTest.addItem("butterfly", 5, true);
		spriteRETest.renderSprites();
		
		BufferedImage expectedImg = null;
		BufferedImage actualImg = null;
		
		for(Sprite s : spriteRETest.getDOMList()) {
			Item target = (Item)s;
			try {
				expectedImg = ImageIO.read(new File("/images/item/butterfly.gif"));
				actualImg = ImageIO.read((ImageInputStream) target.getImage().getImage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			compareRasterImages(expectedImg, actualImg);
		}
	
	}
	
	private void compareRasterImages(BufferedImage expectedImg, BufferedImage actualImg) throws AssertionError {
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
	            System.out.println("Finish Checking");
	        }
	    }
	    System.out.println("Finish Checking");
	}
}
