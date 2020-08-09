package racingcar.service;

import racingcar.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private int racingCount;
    private List<RacingCar> racingCars;
    private List<RacingRound> roundResults = new ArrayList<>();

    public RacingGame(List<String> racingCars, int racingCount) {
        this.racingCount = racingCount;
        this.racingCars = participate(racingCars);
    }

    public void start() {
        for (int i = 0; i < racingCount; i++) {
            roundResults.add(new RacingRound(racingCars.stream()
                    .map(racingCar -> racingCar.run(adjustRule()))
                    .collect(Collectors.toList())));
        }
    }

    public List<RacingRound> getRoundResults() {
        return roundResults;
    }

    public List<RacingCar> participate(List<String> racingCars) {
        List<RacingCar> cars = new ArrayList<>();
        for (int i = 0; i < racingCars.size(); i++) {
            cars.add(new RacingCar(racingCars.get(i)));
        }
        return cars;
    }

    public Rule adjustRule() {
        return new RacingRule();
    }


}
