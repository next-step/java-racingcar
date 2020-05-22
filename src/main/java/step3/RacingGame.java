package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private int carCnt;
    private int[] carPositions;
    private List<int[]> resultStack = new ArrayList<>();

    public void play(int carCnt, int gameCnt) {
        this.carCnt = carCnt;

        for (int i = 0; i < gameCnt; i++) {
            resultStack.add(move());
        }
        showResult();
    }

    private int[] move() {
        carPositions = new int[carCnt];
        for (int i = 0; i < carCnt; i++){
            carPositions[i] = getDistance();
        }
        return carPositions;
    }

    private int getDistance() {
        Random random = new Random();
        int distance = random.nextInt(10);
        return distance >= 4 ? distance : 0;
    }

    public void showResult() {
        ResultView resultView = new ResultView(resultStack);
        resultView.showResult();
    }
}
