package guns;

import entity.Entity;
import math.Vector2f;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Bullet extends Entity {

    protected Vector2f direction;
    protected double speed;
    protected double damage;
    protected double distance;

    public Bullet(Vector2f location, Vector2f direction, double speed, double damage, double distance) {
        super(location);
        this.direction = direction;
        this.speed = speed;
        this.damage = damage;
        this.distance = distance;
    }

    @Override
    public boolean update(float delta) {

        Vector2f velocity = direction.multiply(speed);

        location.addi(velocity);
        distance -= velocity.getLength();

        if (distance <= 0) {
            return false;
        }

        return true;
    }

    @Override
    public void draw(Graphics g) {

        Vector2f vector = location.sub(direction.multiply(speed * 5));

        g.setColor(Color.yellow);
        g.drawLine(location.x, location.y, vector.x, vector.y);
    }
}
