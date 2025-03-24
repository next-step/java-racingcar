package step4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private List<Car> cars;

    public RacingGame(int carCount, List<String> carNames) {
        cars = new ArrayList<>();
        for(int i = 0; i < carCount; i++) {
            Car car = new Car(new Random(),carNames.get(i));
            cars.add(car);
        }
    }

    public List<List<String>> play(int roundCount) {
        List<List<String>> FinalResults = new ArrayList<>();

        for(int i = 0; i < roundCount; i++) {
            List<String> RoundResults = new ArrayList<>();
            for(Car car : cars) {
                car.move();
                String result = car.getCarName() + " : " + car.draw();
                RoundResults.add(result);
            }
            FinalResults.add(RoundResults);
        }

        return FinalResults;
    }
}
