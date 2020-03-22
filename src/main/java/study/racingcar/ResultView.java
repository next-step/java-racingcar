package study.racingcar;

import java.util.Random;

public class ResultView {
    private static final int BOUND = 10;
    private static final int BASE_POINT = 4;
    private static final String CAR_DISPLAY = "-";
    private RacingGame racingGame;

    public ResultView(RacingGameVo racingGameVo) {
        this.racingGame = new RacingGame(racingGameVo, getMovableDistance());
    }

    public void printResult() {
        int[] carPositions;
        System.out.println("실행 결과");
        while (racingGame.isMovable()) {
            carPositions = racingGame.move();
            print(carPositions);
        }
    }

    private void print(int[] carPositions) {
        for (int i = 0; i < carPositions.length; i++) {
            System.out.println(new String(new char[carPositions[i]])
                    .replace("\0", CAR_DISPLAY));
        }
        System.out.println();
    }

    private MovableDistance getMovableDistance() {
        return () -> {
            int random = (new Random()).nextInt(BOUND);
            return (random >= BASE_POINT) ? 1 : 0;
        };
    }
}
