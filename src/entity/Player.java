package entity;

import map.Location;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Player extends Entity {

    private int size;

    private boolean moveUp;
    private boolean moveDown;
    private boolean moveLeft;
    private boolean moveRight;

    public Player(Location location) {
        super(location);

        this.size = 30;
    }

    public void moveUp() {

    }

    public void moveDown() {

    }

    public void moveLeft() {

    }

    public void moveRight() {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void draw(Graphics g) {

        g.setColor(Color.green);
        g.fillOval((int) location.x, (int) location.y, size, size);

    }

    private void resetMovement() {
        moveUp = false;
        moveDown = false;
        moveRight = false;
        moveLeft = false;
    }
}
