package main;

import entity.Player;
import entity.zombie.Zombie;
import guns.Bullet;
import guns.Gun;
import math.Vector2f;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

public class ZombieGame extends BasicGameState {

    private Player player;
    private Zombie zombie;

    private List<Bullet> bullets;

    private float lastTick;

    @Override
    public int getID() {
        return GameStates.IN_GAME.getId();
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        player = new Player(new Vector2f(0, 0));
//        zombie = new Zombie(new Vector2f(300, 300));
        bullets = new ArrayList<>();

        Zombie.setPlayer(player);

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        int width = gameContainer.getWidth();
        int height = gameContainer.getHeight();

        player.draw(graphics);
//        zombie.draw(graphics);

        for (Bullet bullet : bullets) {
            bullet.draw(graphics);
        }

        /* GUI components */
        // Gun
        graphics.setColor(Color.white);
        Gun gun = player.getGun();

        graphics.drawString("Gun: " + gun.getName(), 10, height - 70);
        if (gun.isReloading()) {
            graphics.setColor(Color.red);
            graphics.drawString("Clip: Reloading...", 10, height - 50);
            graphics.setColor(Color.white);
        } else {
            graphics.drawString("Clip: " + gun.getClipSize() + "/" + gun.getClipCapacity(), 10, height - 50);
        }
        graphics.drawString("Ammo left: " + gun.getTotalAmmunition(), 10, height - 30);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

        // TODO: Implement delta time
        float delta = 0.1f;

        player.setDirection(
                new Vector2f(
                        gameContainer.getInput().getMouseX(),
                        gameContainer.getInput().getMouseY()
                ).subi(player.getLocation()).normalize()
        );

        // TODO: Move to separate listener class
        if (gameContainer.getInput().isKeyDown(Input.KEY_W)) {
            player.moveUp();
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_S)) {
            player.moveDown();
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_A)) {
            player.moveLeft();
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_D)) {
            player.moveRight();
        }
        if (gameContainer.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            if (player.getGun().canShoot()) {
                Bullet bullet = player.shoot();
                bullets.add(bullet);
            }
        }
        if (gameContainer.getInput().isKeyPressed(Input.KEY_R)) {
            if (player.getGun().canReload()) {
                player.getGun().reload();
            }
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_ESCAPE)) {
            gameContainer.exit();
        }

        player.update(delta);
//        zombie.update(delta);

        bullets.removeIf(p -> !p.update(delta));

    }
}
