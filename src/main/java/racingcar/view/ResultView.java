package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Race;

import java.util.Iterator;
import java.util.List;

public class ResultView {
    public static void printCurrentState(Race race) {
        List<Car> cars = race.getCars();

        System.out.println("< Round " + race.getCurrentRound() + ">");
        for (Car car : cars) {
            printLocationOfCar(car);
        }
        System.out.println();
    }

    static void printLocationOfCar(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getLocation(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printGameOver(Race race) {
        printWinners(race);
    }

    public static void printWinners(Race race) {
        List<Car> winners = race.getWinners();

        System.out.print("레이스 결과 : ");
        Iterator it = winners.iterator();

        if (it.hasNext() == false) {
            System.out.println("우승자 없음");
            return;
        }

        System.out.print(((Car) it.next()).getName());
        while (it.hasNext()) {
            System.out.print(", " + ((Car) it.next()).getName());
        }
        System.out.println(" 우승!");
    }
}
