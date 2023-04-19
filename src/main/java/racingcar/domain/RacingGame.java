package racingcar.domain;

import racingcar.dto.UserInput;
import racingcar.strategy.NumberGeneratorStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private int carNumber;
    private int gameRound;

    public RacingGame() {
    }

    public RacingGame(UserInput userInput) {
        carNumber = userInput.getCarNumber();
        gameRound = userInput.getGameRound();
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
        return cars.move(numberGeneratorStrategy);
    }
}
