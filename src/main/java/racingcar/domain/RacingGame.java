package racingcar.domain;

import racingcar.view.ResultView;

public class RacingGame {
    private static final int END_GAME = 0;

    private int playCount;
    final int carCount;

    private final Cars cars;

    public RacingGame(int carCount,int playCount) {
        this.carCount = carCount;
        this.playCount = playCount;

        this.cars = new Cars(carCount);
    }

    public void start() {
        ResultView.readyPrint();

        while(isEnd()) {
            ResultView.print(this.cars);
            cars.move();
        }
    }

    public boolean isEnd() {
        boolean end = playCount > END_GAME;
        this.playCount--;

        return end;
    }
}