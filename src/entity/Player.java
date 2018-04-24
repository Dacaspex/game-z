package entity;

import math.Vector2f;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Player extends LivingEntity {

    private int size;

    private boolean moveUp;
    private boolean moveDown;
    private boolean moveLeft;
    private boolean moveRight;

    private double speed;

    public Player(Vector2f location) {
        super(location);

        this.size = 30;
        this.speed = 5;
    }

    public void moveUp() {
        moveUp = true;
    }

    public void moveDown() {
        moveDown = true;
    }

    public void moveLeft() {
        moveLeft = true;
    }

    public void moveRight() {
        moveRight = true;
    }

    @Override
    public void update(float delta) {

        double _speed = delta * speed;

        if (moveUp) {
            if (moveRight || moveLeft) {
                _speed = (1 / Math.sqrt(2)) * _speed;
            }

            location.y -= _speed;
        }

        if (moveDown) {
            if (moveRight || moveLeft) {
                _speed = (1 / Math.sqrt(2)) * _speed;
            }

            location.y += _speed;
        }

        if (moveLeft) {
            if (moveUp || moveDown) {
                _speed = (1 / Math.sqrt(2)) * _speed;
            }

            location.x -= _speed;
        }

        if (moveRight) {
            if (moveUp || moveDown) {
                _speed = (1 / Math.sqrt(2)) * _speed;
            }

            location.x += _speed;
        }

        resetMovement();
    }

    @Override
    public void draw(Graphics g) {

        g.setColor(Color.blue);
        g.fillOval((int) location.x, (int) location.y, size, size);

    }

    private void resetMovement() {
        moveUp = false;
        moveDown = false;
        moveRight = false;
        moveLeft = false;
    }
}
