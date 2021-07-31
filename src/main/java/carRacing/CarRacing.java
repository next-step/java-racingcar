package carRacing;

import java.util.ArrayList;


public class CarRacing {

    private final RandomMovigStrategy randomMovigStrategy = new RandomMovigStrategy();

    private ArrayList<Car> prepareCars(int numberOfCars) {
        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i<numberOfCars; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    void start(int numberOfCars, int numberOfRacing) {
        if (numberOfCars <= 0 || numberOfRacing <= 0) {
            throw new IllegalArgumentException("레이싱 시작을 하기 위한 숫자 값이 올바르지 않습니다.");
        }

        ArrayList<Car> cars = prepareCars(numberOfCars);

        for (int round = 1; round <= numberOfRacing; round++) {
            ResultView.divideRound(round);

            for (Car car : cars) {
                int position = car.go(randomMovigStrategy);
                ResultView.printPosition(position);
            }
        }
    }
}
