import java.util.Random;
import java.util.Scanner;

public class RacingGame {

    private int time;
    private int[] carPositions;

    public RacingGame(int time, int count) {
        this.time = time;
        this.carPositions = new int[count];
    }

    public int getTime() {
        return this.time;
    }

    public int[] getCarPosition() {
        return this.carPositions;
    }

    public static void main(String[] args) {
        InputView input = new InputView();

        RacingGame game = input.input();
        GameProgress progress = new GameProgress();

        progress.progress(game);
    }

}
