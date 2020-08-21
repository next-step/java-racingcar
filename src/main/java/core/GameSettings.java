package core;

public class GameSettings {
    public static String[] carNames;
    public static int round;

    GameSettings(String[] carNames, int round) {
        this.carNames = carNames;
        this.round = round;
    }

    public static GameSettings settings(String[] carNames, int round) {
        return new GameSettings(carNames, round);
    }
}
