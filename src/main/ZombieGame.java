package main;

import entity.Player;
import entity.zombie.Zombie;
import math.Vector2f;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class ZombieGame extends BasicGameState {

    private Player player;

    private Zombie zombie;

    private float lastTick;

    @Override
    public int getID() {
        return GameStates.IN_GAME.getId();
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        player = new Player(new Vector2f(100, 100));
        zombie = new Zombie(new Vector2f(300, 300));

        Zombie.setPlayer(player);

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        player.draw(graphics);
        zombie.draw(graphics);

        lastTick = System.nanoTime();

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

        // TODO: Implement delta time
        float delta = 0.1f;

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
        if (gameContainer.getInput().isKeyDown(Input.KEY_ESCAPE)) {
            gameContainer.exit();
        }

        player.update(delta);
        zombie.update(delta);

    }
}
