package racinggame;

import java.util.List;

public class RacingGame {

    private static final int MIN_VALUE_OF_CAR_MOVE = 4;

    private final NumberGenerator numberGenerator;

    public RacingGame(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public RacingGameResult run(List<Car> cars, int round) {
        RacingGameResult result = new RacingGameResult();
        for (int i = 0; i < round; i++) {
            result.add(runRound(cars));
        }
        return result;
    }

    private RacingGameRoundResult runRound(List<Car> cars) {
        RacingGameRoundResult roundResult = new RacingGameRoundResult();
        cars.forEach(car -> {
            moveCar(car);
            roundResult.add(RacingGameCarResult.from(car));
        });
        return roundResult;
    }

    private void moveCar(Car car) {
        if (isCarMovable()) {
            car.move();
        }
    }

    private boolean isCarMovable() {
        return numberGenerator.generateNumber() >= MIN_VALUE_OF_CAR_MOVE;
    }

}
