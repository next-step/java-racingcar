package study.step4.model.view;

public class Input {

    private static final String CAR_NAME_SPLITER = ",";

    private int carNumber;
    private int gameRound;
    private String[] carNames;

    public Input(int carNumber, int gameRound) {
        this.carNumber = carNumber;
        this.gameRound = gameRound;
    }

    public Input(String carNames, int gameRound) {
        this.carNames = carNames.split(CAR_NAME_SPLITER);
        this.carNumber = this.carNames.length;
        this.gameRound = gameRound;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getGameRound() {
        return gameRound;
    }

    public String[] getCarNames() {
        return carNames;
    }
}
