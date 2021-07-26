package racingCar.view;

import racingCar.model.Cars;

public class ResultView {
    private ResultView() {
    }

    public static void printCars(Cars cars) {
        System.out.println("\n실행결과");
        cars.play();
    }
}
