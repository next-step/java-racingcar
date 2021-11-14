package step3.domain;

public class GameWinner {
    private String name;

    private GameWinner() {
    }

    public GameWinner(String name) {
        this.name = name;
    }

    public static GameWinner of(String name) {
        return new GameWinner(name);
    }

    public String getName() {
        return name;
    }
}
