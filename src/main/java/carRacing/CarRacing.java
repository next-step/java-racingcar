package carRacing;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private final RandomMovigStrategy randomMovigStrategy = new RandomMovigStrategy();

    private Cars prepareCars(List<String> carNames) {

        if (carNames == null || carNames.size() == 0) {
            throw new IllegalArgumentException("레이싱 시작을 하기 위한 자동차 이름들이 존재하지 않습니다.");
        }

        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return new Cars(cars);
    }


    Cars start(List<String> carNames, int numberOfRacing) {

        if (numberOfRacing <= 0) {
            throw new IllegalArgumentException("레이싱 시작을 하기 위한 숫자 값이 올바르지 않습니다.");
        }

        Cars cars = prepareCars(carNames);

        for (int round = 1; round <= numberOfRacing; round++) {
            ResultView.divideRound(round);
            cars.move(randomMovigStrategy);
        }

        return cars;
    }
}
