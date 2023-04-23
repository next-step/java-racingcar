package racingcar.domain;

import racingcar.dto.UserInput;
import racingcar.strategy.NumberGeneratorStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private List<String> carNames;
    private int gameRound;

    public RacingGame() {
    }

    public RacingGame(UserInput userInput) {
        gameRound = userInput.getGameRound();
        carNames = userInput.getCarNames();
    }

    public List<Scores> startGame(NumberGeneratorStrategy numberGeneratorStrategy) {
        Cars cars = new Cars(carNames);
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
