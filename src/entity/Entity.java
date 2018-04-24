package entity;

import math.Vector2f;
import org.newdawn.slick.Graphics;

public abstract class Entity {

    protected Vector2f location;

    public Entity(Vector2f location) {
        this.location = location;
    }

    public double getX() {
        return location.x;
    }

    public void setX(float x) {
        location.x = x;
    }

    public double getY() {
        return location.y;
    }

    public void setY(float y) {
        location.y = y;
    }

    public Vector2f getLocation() {
        return location;
    }

    public void setLocation(Vector2f location) {
        this.location = location;
    }

    public abstract void update(float delta);

    public abstract void draw(Graphics g);
}
