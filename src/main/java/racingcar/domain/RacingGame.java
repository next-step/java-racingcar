package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private final int carNumber;
    private final int gameRound;

    public RacingGame(PositiveNumber positiveNumber) {
        carNumber = positiveNumber.getCarNumber();
        gameRound = positiveNumber.getGameRound();
    }

    public List<Scores> startGame(RandomNumberGenerator numberGenerator) {
        Cars cars = new Cars(carNumber);
        return round(cars, numberGenerator);
    }

    public List<Scores> round(Cars cars, RandomNumberGenerator numberGenerator) {
        return IntStream.range(0, gameRound)
                .mapToObj(i -> race(cars, numberGenerator))
                .collect(Collectors.toList());
    }

    private Scores race(Cars cars, RandomNumberGenerator numberGenerator) {
        Scores roundScores = new Scores();
        for (Car car : cars.getCars()) {
            car.move(numberGenerator);
            roundScores.addScore(new Score(car.getPoint()));
        }
        return roundScores;
    }
}
