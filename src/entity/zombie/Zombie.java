package entity.zombie;

import entity.LivingEntity;
import entity.Player;
import math.Vector2f;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Zombie extends LivingEntity {

    private int size;
    private double speed;
    private static Player player;

    public Zombie(Vector2f location) {
        super(location);

        this.size = 30;
        this.speed = 2;
        this.health = 100;
        this.maxHealth = 100;
    }

    public int getSize() {
        return size;
    }

    public double getSpeed() {
        return speed;
    }

    @Override
    public boolean update(float delta) {

        if (health <= 0) {
            // TODO: Temporary measure
            return true;
        }

        double _speed = delta * speed;

        Vector2f direction = player
                .getLocation()
                .sub(location)
                .normalize()
                .multiply((float) _speed);

        location = location.add(direction);

        return true;
    }

    @Override
    public void draw(Graphics g) {

        // Draw zombie
        g.setColor(new Color(0, 140, 20));
        g.fillOval(
                (int) (location.x - size / 2),
                (int) (location.y - size / 2),
                size,
                size
        );

        // Draw health bar
        g.setColor(Color.red);
        g.fillRect(location.x - 20, location.y - 30, 40, 5);
        g.setColor(Color.green);
        g.fillRect(location.x - 20, location.y - 30, (float) (health / maxHealth) * 40, 5);

    }

    public static void setPlayer(Player player) {
        Zombie.player = player;
    }
}
