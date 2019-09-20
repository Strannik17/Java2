package ru.gb.jtwo.online.circles;

import java.awt.*;

public class BackGround {

    private int changeSpeed;
    private int counter;

    BackGround(int updateTime){
        this.changeSpeed = updateTime;
    }

    void update(GameCanvas canvas){
        counter++;

        if ((counter % changeSpeed) == 0) {
            Color color = new Color(
                    (int)(Math.random() * 255),
                    (int)(Math.random() * 255),
                    (int)(Math.random() * 255)
            );
            canvas.setBackground(color);
        }

    }
}
