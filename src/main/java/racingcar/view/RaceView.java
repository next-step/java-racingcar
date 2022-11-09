package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.StringJoiner;

public class RaceView {
    private static final String MOVE_SYMBOL = "-";

    public RaceView() {}


    public void printCars(Cars cars) {
        cars.getCarList().forEach(this::printCarDistance);
        System.out.println();
    }

    private void printCarDistance(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print(MOVE_SYMBOL);
        }
        System.out.println();
    }

    public void printWinners(Cars cars) {
        StringJoiner joiner = new StringJoiner(",");
        cars.getWinners().forEach(joiner::add);
        System.out.println(joiner.toString() + "가 최종 우승했습니다.");
    }
}
