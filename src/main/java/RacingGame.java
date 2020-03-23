import java.util.Random;
import java.util.Scanner;

public class RacingGame {

    private int time;
    private int[] carPositions;
    private String[] carNames;

    public RacingGame(String[] carNames, int time) {
        this.time = time;
        this.carPositions = new int[carNames.length];
        this.carNames = carNames;
    }

    public int getTime() {
        return this.time;
    }

    public int[] getCarPosition() {
        return this.carPositions;
    }

    public String[] getCarNames() { return this.carNames; }

    public static void main(String[] args) {
        InputView inputView = new InputView();

        RacingGame racingGame = inputView.input();
        GameProgress gameProgress = new GameProgress();

        gameProgress.progress(racingGame);
    }

}
