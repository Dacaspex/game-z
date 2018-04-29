package guns;

import math.Vector2f;

public class Gun {

    protected double damage;
    protected double bulletSpeed;

    protected int totalAmmunition;
    protected int clipSize;
    protected int clipCapacity;

    protected long reloadTimer;
    protected long reloadTime;

    public Gun() {
        this.bulletSpeed = 10;
        this.damage = 20;
    }

    public void reload() {}

    public void canReload() {}

    public Bullet shoot(Vector2f start, Vector2f direction) {
        return new Bullet(start, direction, bulletSpeed, damage);
    }
}
