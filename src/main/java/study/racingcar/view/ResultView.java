package study.racingcar.view;

import study.racingcar.car.Car;

import java.util.List;

public class ResultView {

    private static final ResultView instance = new ResultView();

    public static ResultView getInstance() {
        return instance;
    }

    private ResultView() {}

    public void displayCars(List<Car> cars) {
        for (Car car : cars) {
            displayCar(car);
        }
        // 각각의 시도가 끝나면 개행
        System.out.println();
    }

    private void displayCar(Car car) {
        for (int position = 0; position < car.getCurrentPosition(); position++) {
            System.out.print('-');
        }
        System.out.println();
    }

}
