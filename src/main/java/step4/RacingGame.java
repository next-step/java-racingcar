package step4;

import java.util.*;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(int carCount, List<String> carNames) {
        cars = new ArrayList<>();
        MoveCondition randomCondition = MoveConditions.randomCondition();
        for(int i = 0; i < carCount; i++) {
            Car car = new Car(carNames.get(i), randomCondition);
            cars.add(car);
        }
    }

    public List<Map<String, Integer>>  play(int roundCount) {
        List<Map<String, Integer>>  FinalResults = new ArrayList<>();

        for(int i = 0; i < roundCount; i++) {
            HashMap<String, Integer> RoundResults = new HashMap<>();
            for(Car car : cars) {
                car.move();
                RoundResults.put(car.getCarName(), car.getPosition());
            }
            FinalResults.add(RoundResults);
        }

        return FinalResults;
    }
}
