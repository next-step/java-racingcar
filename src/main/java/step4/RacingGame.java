package step4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(int carCount) {
        cars = new ArrayList<>();
        for(int i = 0; i < carCount; i++) {
            cars.add(new Car(new Random()));
        }
    }

    public List<List<String>> play(int roundCount) {
        List<List<String>> FinalResults = new ArrayList<>();

        for(int i = 0; i < roundCount; i++) {
            List<String> RoundResults = new ArrayList<>();
            for(Car car : cars) {
                car.move();
                RoundResults.add(car.draw(car.getPosition()));
            }
            FinalResults.add(RoundResults);
        }

        return FinalResults;
    }
}
