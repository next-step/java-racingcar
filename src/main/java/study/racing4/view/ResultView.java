package study.racing4.view;

import study.racing4.Car;
import study.racing4.CarCollection;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final char POSITION_MARK = '-';

    public void printCarPosition(CarCollection cars) {

        cars.apply(car -> {
            System.out.print(car.getName() + " : " + POSITION_MARK);
            IntStream.range(0, car.getPosition())
                    .forEach(t -> System.out.print(POSITION_MARK));
            System.out.println();
        });
        System.out.println();
    }

    public void printWinner(List<Car> cars) {

        String winnerString = cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));

        System.out.println(winnerString + "가 최종 우승했습니다.");
    }

}
