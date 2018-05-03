package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {

    public Main(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {

        this.addState(new ZombieGame());

    }

    public static void main(String[] args) {

        try {
            AppGameContainer appgc;

            appgc = new AppGameContainer(new Main("Slick2D test"));
            appgc.setDisplayMode(640, 480, false);
            appgc.start();

        } catch (SlickException exception) {
            exception.printStackTrace();
        }

    }

}
