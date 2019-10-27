package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private int time;
    private int[] carPositions;
    private ResultView resultView;
    public RacingGame() {
        this.resultView = new ResultView();
    }

    public int[] carPositionsInitiate(int createCarCount) {
        this.carPositions = new int[createCarCount];
        for (int i = 0; i < carPositions.length; i++) {
            carPositions[i] = 0;
        }
        return carPositions;
    }

    public int getTime(int time) {
        this.time = time;
        return time;
    }

    public int getRandomNumber() {
        return new Random().nextInt(10);
    }

    public int isMove() {
        if (getRandomNumber() >= 4) {
            return 1;
        }
        return 0;
    }

    public void execute() {
        for (int i = 0; i < time; i++) {
            int[] result = move().clone();
            resultView.addResult(result);
        }
    }

    public int[] move() {
        for (int i = 0; i < carPositions.length; i++) {
            carPositions[i] += isMove();
        }
        return carPositions;
    }

    public void print() {
        resultView.printResultView();
    }




}
