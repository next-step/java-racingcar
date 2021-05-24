package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private Util util = new Util();
    private List<Car> carInfo = new ArrayList<>();

    public List<Car> splitString(String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            if (util.invalidedName(carName)) {
                Car car = new Car(carName);
                carInfo.add(car);
            }
        }
        return carInfo;
    }
}
