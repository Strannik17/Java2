package ru.gb.jtwo.online.circles;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseController extends MouseAdapter {
    GameCanvas canvas;

    public MouseController(GameCanvas canvas) {
        super();
        this.canvas = canvas;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);

        if (e.getButton() == MouseEvent.BUTTON1)
        {
            canvas.getGameWindow().addSprite();
        }

        if (e.getButton() == MouseEvent.BUTTON3)
        {
            canvas.getGameWindow().deleteSprite();
        }

    }


}
