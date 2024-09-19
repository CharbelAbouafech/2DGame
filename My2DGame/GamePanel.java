package My2DGame;

import Entity.Player;
import tile.TileManager;
import Object.SuperObject;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

        // SCREEN SETTINGS
        final int originalTileSize = 16; // 16x16 Tile
        final int scale = 3; //scale bc 16x16 is too small to see

        public final int tileSize = originalTileSize * scale; // 48x48
        public final int maxScreenCol = 16;
        public final int maxScreenRow = 12;
        public final int screenWidth = tileSize * maxScreenCol; //768 pixels
        public final int screenHeight = tileSize * maxScreenRow; //576 pixels

        // WORLD SETTINGS
        public final int maxWorldCol = 50;
        public final int maxWorldRow = 50;

        int FPS = 60;

        // SYSTEM
        TileManager tileM = new TileManager(this);
        KeyHandler keyH = new KeyHandler();
        Sound music = new Sound();
        Sound se = new Sound();
        public CollisionChecker cChecker = new CollisionChecker(this);
        public AssetSetter aSetter = new AssetSetter(this);
        public UI ui = new UI(this);
        Thread gameThread; //to use it we implement runnable

        // ENTITY AND OBJECT
        public Player player = new Player(this,keyH);
        public SuperObject[] obj = new SuperObject[10];



        public GamePanel() {
            this.setPreferredSize(new Dimension(screenWidth, screenHeight));
            this.setBackground(Color.BLACK);
            this.setDoubleBuffered(true);
            this.addKeyListener(keyH);
            this.setFocusable(true); //gamepanel can be focused to use key input

        }

        public void setupGame() {
            aSetter.setObject();
            PlayMusic(0);

        }

        public void startGameThread() {
            gameThread = new Thread(this);
            gameThread.start();

        }

        @Override
       /* public void run() {

                double drawInterval =  (double) 1000000000 / FPS;
                double nextDrawTime = System.nanoTime() + drawInterval;

                while(gameThread != null) {

                    long currentTime = System.nanoTime();

                    //1 UPDATE: update information such as character positions
                    update();
                    //2 DRAW: draw the screen with the updated information
                    repaint();//that's how you call paintComponent method

                    try {
                        double remainingTime = nextDrawTime - System.nanoTime();
                        remainingTime = remainingTime / 1000000;

                        if (remainingTime < 0) {
                            remainingTime = 0;
                        }

                        Thread.sleep((long) remainingTime);

                        nextDrawTime += drawInterval;


                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
        } */
        public void run() {

            double drawInterval = 1000000000 / FPS;
            double delta = 0;
            long lastTime = System.nanoTime();
            long currentTime;
            long timer = 0;
            int frames = 0;

            while (gameThread != null) {

                currentTime = System.nanoTime();

                delta += (currentTime - lastTime) / drawInterval;
                timer += currentTime - lastTime;
                lastTime = currentTime;

                if(delta >= 1) {
                    update();
                    repaint();
                    delta--; // to reset delta
                    frames++;
                }

                if(timer >= 1000000000) {
                    frames = 0;
                    timer = 0;
                }
            }
        }
        public void update() {
            player.update();

        }
        public void paintComponent(Graphics g){ //graphics always you to draw objects on screen

            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D)g; //we change graphics g to graphics2D

            // TILE
            tileM.draw(g2);

            // DEBUG
            long drawStart = 0;
            if(keyH.checkDrawTime == true) {
                drawStart = System.nanoTime();
            }

                // OBJECT
            for(int i = 0; i < obj.length; i++) {
                if(obj[i] != null) {
                    obj[i].draw(g2, this);
                }
            }

            // PLAYER
            player.draw(g2);

            // UI
            ui.draw(g2);

            //DEBUG
            if(keyH.checkDrawTime == true) {
                long drawEnd = System.nanoTime();
                long passed = drawEnd - drawStart;
                g2.setColor(Color.white);
                g2.drawString("Draw Time: " + passed, 10 , 400);
                System.out.println("DRAW TIME: " + passed);
            }


            g2.dispose(); // dispose of this graphics context and release any system resources that it is using



        }

        // MUSIC AND SOUNDS

        public void PlayMusic(int i) {
            music.setFile(i);
            music.play();
            music.loop();

        }

        public void StopMusic() {
            music.stop();
        }

        public void PlaySoundEffect(int i) {
            se.setFile(i);
            se.play();
        }

}
