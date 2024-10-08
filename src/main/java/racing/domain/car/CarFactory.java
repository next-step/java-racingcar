package racing.domain.car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static List<Car> generateCars(String name) {
        String[] carNames = getSplit(name);

        if (carNames.length < 2) {
            throw new IllegalArgumentException("2개 이상의 차를 입력해주세요.");
        }

        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carNameLenthCheck(carName);
            Car car = new Car(carName, 0);
            carList.add(car);
        }

        return carList;
    }

    private static void carNameLenthCheck(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private static String[] getSplit(String name) {
        return name.split(",");
    }

}
