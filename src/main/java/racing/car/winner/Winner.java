package racing.car.winner;

import racing.car.car.Car;
import racing.car.car.Cars;
import java.util.List;

public class Winner {

    public static List<Car> getWinnerInfo(int max, Cars cars) {
        return cars.findWinner(max);
    }

}
