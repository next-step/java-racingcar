package domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {
    private Rule rule;
    private Integer gameCount;
    private List<Car> cars = new ArrayList<>();

    private RacingGame(Rule rule, Integer gameCount){
        this.rule = rule;
        this.gameCount = gameCount;
    }

    public RacingGame(Rule rule, Integer gameCount, Integer carCount) {
        this(rule, gameCount);
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public RacingGame(Rule rule, Integer gameCount, String[] carNames) {
        this(rule, gameCount);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public RacingGameResult play(){
        if(rule == null || gameCount == null || cars.size() == 0){
            throw new IllegalStateException("Have to init first");
        }

        RacingGameResult racingGameResult = new RacingGameResult();

        IntStream.rangeClosed(1, gameCount)
            .mapToObj(this::playCycle)
            .forEach(racingGameResult::addRoundResult);

        racingGameResult.createRanking(cars);

        return racingGameResult;
    }

    private RoundResult playCycle(int roundNumber){
        cars.stream()
            .filter(c -> rule.canPass())
            .forEach(Car::move);

        return new RoundResult(roundNumber, cars.stream()
            .map(CarResult::new)
            .collect(Collectors.toList()));
    }

    public int getGameCount() {
        return gameCount;
    }

    public List<Car> getCars() {
        return cars;
    }
}
