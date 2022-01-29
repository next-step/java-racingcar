package racing;

import java.util.List;

public class Round {

    public static RoundResult play(List<Car> cars) {
        for(Car car : cars) {
            car.move(makeRandom());
        }
        return new RoundResult(cars);
    }

    private static int makeRandom() {
        return (int) (Math.random() * 10);
    }
}
