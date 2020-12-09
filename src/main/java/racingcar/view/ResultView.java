package racingcar.view;

import racingcar.Car;
import racingcar.Cars;

import java.util.List;

public class ResultView {
    private static final String MOVE_COUNT_VIEW = "-";
    private List<Car> carList;

    public void resultTitle() {
        System.out.println("\n실행결과");
    }

    public void resultRacing(int playCount, int numberOfCar) {
        resultTitle();

        carList = Cars.ready(numberOfCar);
        for (int i = 0; i < playCount; i++) {
            positionOfCar(carList);
        }
    }

    public void positionOfCar(List<Car> cars) {
        for (Car car : cars) {
            locationCarView(car);
        }
        System.out.println();
    }

    public void locationCarView(Car car) {
        for (int i = 0; i < car.getLocation(); i++) {
            System.out.print(MOVE_COUNT_VIEW);
        }
        car.move();
        System.out.println();
    }
}