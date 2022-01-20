package racingcar;

import java.util.List;
import java.util.Random;

public class RacingCarGame {

    private int tryCount;
    private List<String> racingCarList;
    private String[] racingResults;
    private List<String> winners;

    private static final Random RANDOM = new Random();
    private final int MIN_MOVE = 0;
    private final int MAX_MOVE = 9;
    private final int MOVABLE = 4;

    public RacingCarGame(int tryCount, List<String> racingCarList) {
        this.tryCount = tryCount;
        this.racingCarList = racingCarList;
    }

    private int getRandomMove() {
        int move = MIN_MOVE + RANDOM.nextInt(MAX_MOVE - MIN_MOVE + 1);

        checkMovable(move);

        return move;
    }

    private boolean checkMovable(int move) {
        return MOVABLE <= move;
    }
}
