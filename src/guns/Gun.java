package guns;

import math.Vector2f;
import timing.Timer;

public class Gun {

    protected double damage;
    protected double bulletSpeed;
    protected double bulletDistance;

    protected int totalAmmunition;
    protected int clipSize;
    protected int clipCapacity;

    protected long reloadTime;
    protected Timer reloadTimer;

    protected String name;

    public Gun() {
        this.bulletSpeed = 2;
        this.damage = 20;
        this.bulletDistance = 500;
        this.reloadTime = 3000;
        this.reloadTimer = new Timer(reloadTime);
    }

    public double getDamage() {
        return damage;
    }

    public int getTotalAmmunition() {
        return totalAmmunition;
    }

    public int getClipSize() {
        return clipSize;
    }

    public int getClipCapacity() {
        return clipCapacity;
    }

    public long getReloadTime() {
        return reloadTime;
    }

    public String getName() {
        return name;
    }

    public boolean canReload() {
        if (isReloading()) {
            return false;
        }

        if (clipSize == clipCapacity) {
            return false;
        }

        return totalAmmunition != 0;
    }

    public void reload() {
        reloadTimer.start();

        int reloadAmount = Math.min(clipCapacity - clipSize, totalAmmunition);
        clipSize += reloadAmount;
        totalAmmunition -= reloadAmount;
    }

    public boolean isReloading() {
        return reloadTimer.isStarted() && !reloadTimer.finished();
    }

    public boolean canShoot() {
        if (isReloading()) {
            return false;
        }

        return clipSize != 0;
    }

    public Bullet shoot(Vector2f start, Vector2f direction) {
        clipSize--;

        if (clipSize == 0 && canReload()) {
            reload();
        }

        return new Bullet(start, direction, bulletSpeed, damage, bulletDistance);
    }
}
