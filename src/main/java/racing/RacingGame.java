package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private Cars cars;
    public RacingGame(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }

        this.cars = new Cars(carList);
    }

    public GameResult start(int opportunity) {
        List<RoundResult> totalResult = new ArrayList<>();
        for (int i = 0; i < opportunity; i++) {
            totalResult.add(cars.race(generateRandomNumbsList()));
        }
        return new GameResult(totalResult);
    }

    private List<Integer> generateRandomNumbsList() {
        List<Integer> randomNumberList = new ArrayList<>();
        for (int i = 0; i < cars.countTotalCar(); i++) {
            randomNumberList.add(RandomUtil.generateRandomNumberZeroTo(9));
        }
        return randomNumberList;
    }
}
