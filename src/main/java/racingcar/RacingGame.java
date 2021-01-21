package racingcar;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final int rounds;

    public RacingGame(List<String> carNames, int rounds) {
        // TODO: validate()
        this.cars = new Cars(carNames);
        this.rounds = rounds;
    }

    public void play() {
        for (int i = 0; i < rounds; i++) {
            cars.moveAll(new MovementCondition());
        }
        cars.printWinners();
    }
}
