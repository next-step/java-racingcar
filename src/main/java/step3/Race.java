package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race {

    int numberOfAttempts;
    Policy policy;
    List<Car> cars = new ArrayList<>();
    List<RoundResultMap> finalResult = new ArrayList<>();

    public Race(Policy policy, int numberOfCars, int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
        this.policy = policy;
        this.cars = initializeCars(numberOfCars);
        this.finalResult = new ArrayList<>();
    }

    private List<Car> initializeCars(int numberOfCars) {
        return IntStream.range(0, numberOfCars)
                .mapToObj(Car::new)
                .collect(Collectors.toList());
    }


    public List<RoundResultMap> start() {
        IntStream.range(0, numberOfAttempts).forEach(attempt -> {
            List<RaceResultMap> raceResultMaps = new ArrayList<>();
            getRaceResult(attempt, raceResultMaps);
            finalResult.add(new RoundResultMap(attempt, raceResultMaps));
        });
        return finalResult;
    }

    private void getRaceResult(int attempt, List<RaceResultMap> raceResultMaps) {
        for (Car car : cars) {
            RaceResultMap raceResultMap = car.move(attempt, policy);
            raceResultMaps.add(raceResultMap);
        }
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
