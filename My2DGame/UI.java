package My2DGame;

import java.awt.*;
import java.text.DecimalFormat;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80B;
    // BufferedImage KeyImage;

    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean GameFinished = false;

    double PlayTime = 0.0;
    DecimalFormat df = new DecimalFormat("#0.00");

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
        //  OBJ_Key key = new OBJ_Key(gp);
        // KeyImage = key.image;

    }
    public void ShowMessage(String text){
        message = text;
        messageOn = true;
    }
    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);

        if (gp.gameState == gp.playState) {
            // Key counter
            g2.drawString("Keys: " + gp.player.hasKey, 20, 40);

            // Timed message
            if (messageOn) {
                g2.setFont(arial_40.deriveFont(24f));
                g2.drawString(message, getXforCenteredText(message), gp.screenHeight - 60);
                messageCounter++;
                if (messageCounter > 120) {
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }
        if (gp.gameState == gp.pauseState) {
            drawPauseScreen();
        }
        if (gp.gameState == gp.winState) {
            drawWinScreen();
        }
    }
    public void drawWinScreen() {
        g2.setColor(new Color(0, 0, 0, 180));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        g2.setFont(arial_80B);
        g2.setColor(Color.yellow);
        String text = "YOU WIN!";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight / 2 - 40;
        g2.drawString(text, x, y);

        g2.setFont(arial_40);
        g2.setColor(Color.white);
        String sub = "Congratulations!";
        x = getXforCenteredText(sub);
        g2.drawString(sub, x, y + 60);
    }

    public void drawPauseScreen() {
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight / 2;
        g2.drawString(text,x,y);

    }
    public int getXforCenteredText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;
        return x;
    }
}
