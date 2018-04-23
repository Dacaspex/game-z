package main;

public enum GameStates {

    IN_GAME(1);

    private int id;

    GameStates(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
