package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Garage;

public class ResultView {

    private static final String MOVE = "-";

    public static void print(){

        for (Car car : Garage.cars) {
            for (int i = 0; i < car.getMoveCount(); i++) {
                System.out.print(MOVE);
            }
            System.out.println();
        }
        System.out.println();
    }
}
