package study.racingcar;

public class ResultView {
    private static final String CAR_DISPLAY = "-";
    private RacingGame racingGame;

    public ResultView(RacingGameVo racingGameData) {
        this.racingGame =
                new RacingGame(racingGameData, new RandomMovableDistance());
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
}
