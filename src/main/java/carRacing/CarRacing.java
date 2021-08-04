package carRacing;

import java.util.ArrayList;


public class CarRacing {

    private final RandomMovigStrategy randomMovigStrategy = new RandomMovigStrategy();

    private ArrayList<Car> prepareCars(String[] carNames) {
        ArrayList<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return cars;
    }

    private void startCars(ArrayList<Car> cars) {
        for (Car car : cars) {
            car.go(randomMovigStrategy);
            ResultView.printPosition(car);
        }
    }

    void start(String[] carNames, int numberOfRacing) {

        if (carNames == null || carNames.length == 0) {
            throw new IllegalArgumentException("레이싱 시작을 하기 위한 자동차 이름들이 존재하지 않습니다.");
        }

        if (numberOfRacing <= 0) {
            throw new IllegalArgumentException("레이싱 시작을 하기 위한 숫자 값이 올바르지 않습니다.");
        }

        ArrayList<Car> cars = prepareCars(carNames);

        for (int round = 1; round <= numberOfRacing; round++) {
            ResultView.divideRound(round);
            startCars(cars);
        }
    }
}
