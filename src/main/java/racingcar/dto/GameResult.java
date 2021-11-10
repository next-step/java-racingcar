package racingcar.dto;

public class GameResult {

    private final String[][] progress;

    private GameResult(String[][] progress) {
        this.progress = progress;
    }

    public GameResult(int numberOfRound, int numberOfCars) {
        this(new String[numberOfRound][numberOfCars]);
    }

    public void record(int round, int pos, String result) {
        progress[round][pos] = result;
    }

    public String[][] getProgress() {
        return progress;
    }
}
