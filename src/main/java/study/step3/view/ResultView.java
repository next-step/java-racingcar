package study.step3.view;

import study.step3.domain.Car;
import study.step3.domain.Cars;

public class ResultView {
    public static void printOutPositions(Cars cars) {
        for (Car car : cars.getCars()) {
            int position = car.getPosition();
            for (int i = 0; i < position; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
