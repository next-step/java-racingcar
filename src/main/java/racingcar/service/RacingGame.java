package racingcar.service;

import racingcar.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RacingGame {
    private static final String racingCarNamePattern = "^[a-zA-Z0-9]{1,6}$";

    private int racingCount;
    private List<RacingCar> racingCars;
    private List<RacingRound> roundResults = new ArrayList<>();

    public RacingGame(List<String> racingCarList, int racingCount) {
        this.racingCount = racingCount;
        this.racingCars = participate(racingCarList);
    }

    public void start() {
        for (int i = 0; i < racingCount; i++) {
            roundResults.add(new RacingRound(racingCars.stream()
                    .map(racingCar -> racingCar.run(adjustRule()))
                    .map(RacingCar::clone)
                    .collect(Collectors.toList())));
        }
    }

    public List<RacingRound> getRacingResults() {
        return roundResults;
    }

    public List<RacingCar> participate(List<String> racingCarList) {
        List<RacingCar> cars = new ArrayList<>();
        for (int i = 0; i < racingCarList.size(); i++) {
            cars.add(new RacingCar(racingCarList.get(i)));
        }
        return cars;
    }

    public Rule adjustRule() {
        return new RacingRule();
    }

    public static boolean validateCarName(List<String> racingCarNameList) {
        Predicate<String> carNamePattern = Pattern
                .compile(racingCarNamePattern)
                .asPredicate();
        return racingCarNameList.stream().allMatch(carNamePattern);
    }

}
