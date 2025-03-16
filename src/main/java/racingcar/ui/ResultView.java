package racingcar.ui;

import racingcar.domain.Car;

public class ResultView {

    public static void viewRacingCar(Car[] cars) {
        for(Car car : cars) {
            for(int i = 0; i < car.getMoveCount(); i++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();

    }
}
