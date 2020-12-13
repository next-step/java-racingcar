package racingcar.domain;

import racingcar.view.ResultView;

public class RacingGame {
    private static final int END_GAME = 0;

    private int playCount;

    private final Cars cars;

    public RacingGame(String[] carNameArr, int playCount) {
        this.playCount = playCount;

        this.cars = new Cars(carNameArr);
    }

    public void start() {
        ResultView.readyPrint(this.cars);
        while(isEnd()) {
            cars.move();
            ResultView.print(this.cars);
        }
        ResultView.winnersPrint(this.cars);
    }

    public boolean isEnd() {
        boolean end = playCount > END_GAME;
        this.playCount--;

        return end;
    }
}