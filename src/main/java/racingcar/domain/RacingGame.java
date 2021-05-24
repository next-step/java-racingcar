package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private Util util = new Util();

    private List<Car> carInfo = new ArrayList<>();

    public List<Car> splitString(String input) {
        String[] result = input.split(",");
        for (int i = 0; i < result.length; i++) {
            if (util.invalidedName(result[i])) {
                Car car = new Car(result[i]);
                carInfo.add(car);
            }
        }
        return carInfo;
    }
}
