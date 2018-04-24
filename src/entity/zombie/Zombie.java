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
    }

    @Override
    public void update(float delta) {

        double _speed = delta * speed;

        Vector2f direction = player
                .getLocation()
                .sub(location)
                .normalize()
                .multiply((float) _speed);

        location = location.add(direction);
    }

    @Override
    public void draw(Graphics g) {

        g.setColor(new Color(0, 140, 20));
        g.fillOval((int) location.x, (int) location.y, size, size);

    }

    public static void setPlayer(Player player) {
        Zombie.player = player;
    }
}
