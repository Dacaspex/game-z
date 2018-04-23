package entity;

import map.Location;
import org.newdawn.slick.Graphics;

public abstract class Entity {

    protected Location location;

    public Entity(Location location) {
        this.location = location;
    }

    public double getX() {
        return location.x;
    }

    public double getY() {
        return location.y;
    }

    public Location getLocation() {
        return location;
    }

    public abstract void update(float delta);

    public abstract void draw(Graphics g);
}
