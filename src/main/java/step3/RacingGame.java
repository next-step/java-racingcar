package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(int carCount) {
        cars = new ArrayList<>();
        for(int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public List<List<Integer>> play(int roundCount) {
        List<List<Integer>> FinalResults = new ArrayList<>();

        for(int i = 0; i < roundCount; i++) {
            List<Integer> RoundResults = new ArrayList<>();
            for(Car car : cars) {
                car.move();
                RoundResults.add(car.getPosition());
            }
            FinalResults.add(RoundResults);
        }

        return FinalResults;
    }
}
