package Entity;
<<<<<<< HEAD
import My2DGame.GamePanel;
import My2DGame.UtilityTool;
import javax.imageio.ImageIO;
=======

>>>>>>> parent of 378b7f8 (NPC 1)
import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public int worldX, worldY;
    public int speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
}
