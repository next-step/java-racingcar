package study.step3.model.view;

public class Input {
    private int carNumber;
    private int gameRound;

    public Input(int carNumber, int gameRound) {
        this.carNumber = carNumber;
        this.gameRound = gameRound;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getGameRound() {
        return gameRound;
    }
}
