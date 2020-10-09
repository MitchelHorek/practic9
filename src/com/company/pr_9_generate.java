package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

class pr_9_generate extends JFrame {
    private final int width = 1000;
    private final int height = 800;

    public pr_9_generate() {
        super("generator");
        JButton button = new JButton("add shape");
        setLayout(new FlowLayout());
        setSize(width, height);
        add(button);
        button.addActionListener(e -> add_random_shape(getGraphics()));
        setVisible(true);
    }

    public void add_random_shape(Graphics g) {
        int x = new Random().nextInt(width);
        int y = new Random().nextInt(height);

        int len1 = new Random().nextInt(width / 5) + 1;
        int len2 = new Random().nextInt(height / 5) + 1;

        String color = get_random_color();

        int choice = new Random().nextInt(3) + 1;

        Shape_for_9 shape = null;

        switch (choice){
            case 1:
                shape = new Circle(x, y, len1, color);
                break;
            case 2:
                shape = new Rectangle(x, y, len1, len2, color);
                break;
            case 3:
                shape = new Square(x, y, len1, color);
                break;
        }
        shape.draw_shape(g);
    }
    public String get_random_color(){
        return String.format("#%06x", new Random().nextInt(0xffffff + 1));
    }
}
abstract class Shape_for_9 extends JFrame{
    private String color;
    private int x, y, width, height;

    public Shape_for_9(int x, int y, int width, int height, String color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    abstract void draw_shape(Graphics g);

    public int get_height() {
        return height;
    }

    public int get_width() {
        return width;
    }

    public String get_color() {
        return color;
    }

    public int get_x() {
        return x;
    }

    public int get_y() {
        return y;
    }
}
class Circle extends Shape_for_9 {

    public Circle(int x, int y, int radius, String color) {
        super(x, y, radius, radius, color);
    }

    @Override
    void draw_shape(Graphics g) {
        g.setColor(Color.decode(this.get_color()));
        g.fillOval(this.get_x(), this.get_y(), this.get_width(), this.get_height());
    }
}
class Rectangle extends Shape_for_9 {

    Rectangle(int x, int y, int width, int height, String color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw_shape(Graphics g) {
        g.setColor(Color.decode(this.get_color()));
        g.fillRect(this.get_x(), this.get_y(), this.get_width(), this.get_height());
    }
}
class Square extends Shape_for_9 {

    Square(int x, int y, int side, String color) {
        super(x, y, side, side, color);
    }

    @Override
    public void draw_shape(Graphics g) {
        g.setColor(Color.decode(this.get_color()));
        g.fillRect(this.get_x(), this.get_y(), this.get_width(), this.get_height());
    }
}
class Practice_9 {
    public static void main(String[] args) {
        new pr_9_generate();
    }
}