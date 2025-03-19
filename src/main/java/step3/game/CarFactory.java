package step3.game;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private final static String CAR_NAME_DELIMITER = ",";
    public static List<Car> createCars(String names) {
        if (!names.contains(CAR_NAME_DELIMITER)) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)를 기준으로 구분해야 합니다.");
        }
        String[] carNames = names.split(CAR_NAME_DELIMITER);
        if (carNames.length < 2) {
            throw new IllegalArgumentException("자동차는 최소 2대 이상이어야 합니다.");
        }
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
        return cars;
    }
}
