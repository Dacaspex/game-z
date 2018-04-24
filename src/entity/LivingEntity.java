package entity;

import math.Vector2f;
import org.newdawn.slick.Graphics;

public abstract class LivingEntity extends Entity {

    protected double health;
    protected double maxHealth;

    public LivingEntity(Vector2f location) {
        super(location);
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    @Override
    public abstract void update(float delta);

    @Override
    public abstract void draw(Graphics g);
}
