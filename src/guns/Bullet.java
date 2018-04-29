package guns;

import entity.Entity;
import math.Vector2f;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Bullet extends Entity {

    protected Vector2f direction;
    protected double speed;
    protected double damage;

    public Bullet(Vector2f location, Vector2f direction, double speed, double damage) {
        super(location);
        this.direction = direction;
        this.speed = speed;
        this.damage = damage;
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void draw(Graphics g) {

        Vector2f vector = location.sub(direction.multiply(speed));

        g.setColor(Color.yellow);
        g.drawLine(location.x, location.y, vector.x, vector.y);
    }
}
