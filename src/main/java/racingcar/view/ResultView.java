package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Race;

import java.util.ArrayList;

public class ResultView {
    public static void printCurrentState(Race race, ArrayList<Car> cars) {
        System.out.println("< Round " + race.getCurrentRound() + ">");
        for (Car car : cars) {
            printLocationOfCar(car);
        }
        System.out.println();
    }

    static void printLocationOfCar(Car car) {
        for (int i = 0; i < car.getLocation(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printGameOver() {
        System.out.println("Game Over");
    }
}
