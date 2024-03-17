package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race {

    final int numberOfAttempts;
    final Rule rule;
    final int numberOfCars;
    final List<Car> cars;

    List<RoundResultMap> roundResult;

    public Race(int numberOfAttempts, int numberOfCars, Rule rule) {
        this.numberOfAttempts = numberOfAttempts;
        this.numberOfCars = numberOfCars;
        this.rule = rule;
        this.cars = initializeCars(numberOfCars);
        this.roundResult = new ArrayList<>();

    }

    private static RoundResultMap getRoundResult(List<Car> cars) {
        return new RoundResultMap(0, cars.stream()
                .map(RaceResultMap::new)
                .collect(Collectors.toList()));
    }

    public List<Car> initializeCars(int numberOfCars) {
        return IntStream.range(0, numberOfCars)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }

    public List<RoundResultMap> start() {
        for (int i = 0; i < numberOfAttempts; i++) {
            if (i == 0) {
                roundResult.add(getRoundResult(cars));
            }

            if (i != 0) {
                List<RaceResultMap> attemptResultMaps = new ArrayList<>();
                for (Car car : cars) {
                    attemptResultMaps.add(car.move(rule.apply()));
                }
                roundResult.add(new RoundResultMap(i, attemptResultMaps));
            }
        };
        return roundResult;
    }

    public void printResult(List<RoundResultMap> roundResultMaps) {
        System.out.println("실행결과");
        for (RoundResultMap roundResultMap : roundResultMaps) {
            for (RaceResultMap resultMap : roundResultMap.raceResultMaps) {
                System.out.println(resultMap);
            }
            System.out.println("\n");
        }
    }
}
