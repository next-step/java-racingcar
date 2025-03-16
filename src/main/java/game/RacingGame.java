package game;

import view.InputView;
import view.ResultView;

public class RacingGame {
    private Cars cars;

    public void start() {
        ready(readCarCount());
        play(readRoundCount());
    }

    private void ready(int totalCarCount) {
        cars = new Cars(totalCarCount);
    }

    private int readCarCount() {
        return InputView.read("자동차 대수는 몇 대 인가요?");
    }

    private void play(int totalRound) {
        for (int i = 0; i < totalRound; i++) {
            cars.race();
            ResultView.print(cars.getPositions());
        }
    }

    private int readRoundCount() {
        return InputView.read("시도할 회수는 몇 회 인가요?");
    }
}
