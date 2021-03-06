package com.mycompany.app.UserInterface;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * level select class let player choose which level they want to play
 */

public class LevelSelect extends GameState {

    private String[] menuItems = {"Level 1", "Level 2", "Level 3"};
    private int selection = 0;
    BufferedImage img;

    public LevelSelect(GameStateManager gm) {
        this.gm = gm;
        try {
            img = ImageIO.read(new File("assets/tileset.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

    }

    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, GamePanel.PANEL_WIDTH, GamePanel.PANEL_HEIGHT);
        Image tmp = img.getScaledInstance(GamePanel.PANEL_WIDTH, GamePanel.PANEL_HEIGHT, Image.SCALE_SMOOTH);
        //BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        //Graphics2D g2d = resized.createGraphics();
        g.drawImage(tmp, 0, 0, null);
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.BOLD, 40));
        g.drawString("Select a Level", 350, 180);

        for (int i = 0; i < menuItems.length; i++) {
            if (i == selection)
                g.setColor(Color.RED);
            else
                g.setColor(Color.WHITE);

            g.drawString(menuItems[i], 350, 270 + (i * 75));
        }
    }

    public void keyPressed(int key) {
        if (key == KeyEvent.VK_ENTER)
            selectItem();

        if (key == KeyEvent.VK_DOWN) {
            selection++;
            if (selection == menuItems.length)
                selection = 0;
        }

        if (key == KeyEvent.VK_UP) {
            selection--;
            if (selection < 0)
                selection = menuItems.length - 1;
        }

    }

    public void selectItem() {
        switch (selection) {
            case 0:
                gm.setCurrentState(gm.LEVEL1STATE);
                break;
            case 1:
                gm.setCurrentState(gm.LEVEL2STATE);
                break;
            case 2:
                gm.setCurrentState(gm.LEVEL3STATE);
                break;
            default:
                break;
            case 3:
                System.exit(0);
                break;

        }
    }

    public void keyReleased(int key) {

    }
}

