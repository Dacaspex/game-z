package entity;

import guns.BoringPistol;
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

    private Vector2f direction;

    private Gun gun;

    public Player(Vector2f location) {
        super(location);

        this.size = 30;
        this.speed = 5;
        this.gun = new BoringPistol();
    }

    /**
     * @param direction Normalised direction towards player is looking
     */
    public void setDirection(Vector2f direction) {
        this.direction = direction;
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
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
        return gun.shoot(
                location.copy(),
                direction
        );
    }

    @Override
    public boolean update(float delta) {

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

        return true;
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
