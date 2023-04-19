package racingcar.domain;

import racingcar.strategy.NumberGeneratorStrategy;
import racingcar.strategy.RandomNumberGeneratorStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private int carNumber;
    private int gameRound;

    public RacingGame(PositiveNumber positiveNumber) {
        carNumber = positiveNumber.getCarNumber();
        gameRound = positiveNumber.getGameRound();
    }

    public RacingGame() {
    }

    public List<Scores> startGame(NumberGeneratorStrategy numberGeneratorStrategy) {
        Cars cars = new Cars(carNumber);
        return round(cars, numberGeneratorStrategy);
    }

    public List<Scores> round(Cars cars, NumberGeneratorStrategy numberGeneratorStrategy) {
        return IntStream.range(0, gameRound)
                .mapToObj(i -> race(cars, numberGeneratorStrategy))
                .collect(Collectors.toList());
    }

    public Scores race(Cars cars, NumberGeneratorStrategy numberGeneratorStrategy) {
        Scores roundScores = new Scores();
        for (Car car : cars.findAllCars()) {
            car.initMoveStrategy(numberGeneratorStrategy);
            car.move();
            roundScores.addScore(car);
        }
        return roundScores;
    }
}
