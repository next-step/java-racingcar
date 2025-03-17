package racingcar.ui;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {

    public static void viewRacingCar(List<Car> cars) {
        for(Car car : cars) {
            for(int i = 0; i < car.getMoveCount(); i++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();

    }
}
