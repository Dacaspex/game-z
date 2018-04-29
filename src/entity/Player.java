package entity;

import guns.Bullet;
import guns.Gun;
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

    private double angle;

    private Gun gun;

    public Player(Vector2f location) {
        super(location);

        this.size = 30;
        this.speed = 5;
        this.gun = new Gun();
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

    public Bullet shoot() {
        return gun.shoot(location.copy(), new Vector2f(0, 1));
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
        g.fillOval(
                (int) (location.x - size / 2),
                (int) (location.y - size / 2),
                size,
                size
        );

    }

    private void resetMovement() {
        moveUp = false;
        moveDown = false;
        moveRight = false;
        moveLeft = false;
    }
}
