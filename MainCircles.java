package ru.gb.jtwo.online.circles;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;

public class MainCircles extends JFrame {
    /*
    Полностью разобраться с кодом
	Прочитать методичку к следующему уроку
	Написать класс Бэкграунд, изменяющий цвет канвы в зависимости от времени
	 * Реализовать добавление новых кружков по клику используя ТОЛЬКО массивы
	 ** Реализовать по клику другой кнопки удаление кружков (никаких эррейЛист)
    * */

    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    Sprite[] sprites = new Sprite[10];
    BackGround backGround = new BackGround(100);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");

        GameCanvas gameCanvas = new GameCanvas(this);
        add(gameCanvas);
        initGame();
        setVisible(true);
    }

    private void initGame() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    void onDrawPanel(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }

        //Обновление фона
        backGround.update(canvas);
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }

    }

    //Удаление шарика из массива
    protected void deleteSprite(){
        if (sprites.length > 0) {
            Sprite[] newSptites = new Sprite[sprites.length - 1];
            System.arraycopy(sprites, 0, newSptites, 0, sprites.length - 1);
            sprites = newSptites;
        }
    }

    //Добавление шарика
    protected void addSprite(){
        Sprite[] newSprites = new Sprite[sprites.length + 1];
        System.arraycopy(sprites, 0, newSprites, 0, sprites.length);
        newSprites[sprites.length] = new Ball();
        sprites = newSprites;
    }
}
