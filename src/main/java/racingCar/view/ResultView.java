package racingCar.view;

import racingCar.model.Cars;

public class ResultView {
    private ResultView() {
    }

    public static void printCars(Cars cars) {
        System.out.println("\n실행결과");
        cars.play();
    }

    public static void printLocation(int location) {
        for (int i = 0; i < location; i++) {
            System.out.print("-");
        }
    }
}
