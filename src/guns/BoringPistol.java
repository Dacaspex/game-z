package guns;

import timing.Timer;

public class BoringPistol extends Gun {

    public BoringPistol() {
        this.damage = 20;
        this.bulletSpeed = 2000;
        this.bulletDistance = 500;

        this.totalAmmunition = 20;
        this.clipSize = 8;
        this.clipCapacity = 8;

        this.reloadTime = 3000;
        this.reloadTimer = new Timer(reloadTime);

        this.name = "Boring pistol";
    }


}
