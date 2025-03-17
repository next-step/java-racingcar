package game;

import view.InputView;
import view.ResultView;

import java.util.List;

public class RacingGame {
    private static final NumberGenerator RANDOM_NUMBER_GENERATOR = new RandomNumberGenerator();
    private Cars cars;

    public void start() {
        ready(new CarNames(readCarNames()));
        play(new PositiveInteger(readRoundCount()));
    }

    private void ready(CarNames carNames) {
        cars = new Cars(carNames);
    }

    private List<CarName> readCarNames() {
        return InputView.readCarNames("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분).");
    }

    private void play(PositiveInteger totalRound) {
        for (int i = 0; i < totalRound.value(); i++) {
            cars.race(RANDOM_NUMBER_GENERATOR);
            ResultView.print(cars.getPositions());
        }
    }

    private int readRoundCount() {
        return InputView.readPositiveInteger("시도할 회수는 몇 회 인가요?");
    }
}
