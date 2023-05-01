package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.WinnerCars;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printMovementOneRace(List<Car> cars) {
        cars.stream().forEach(System.out::println);
        System.out.println();
    }

    public static void printRacingWinner(WinnerCars winnerCars) {
        System.out.println(winnerCars + "가 최종 우승했습니다.");
    }
}