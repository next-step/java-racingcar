package racingcar.view;

import racingcar.CarList;
import racingcar.SimpleCar;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printRunResultText() {
        System.out.println("실행 결과");
    }

    public static void printCarsRunState(CarList cars) {
        cars.getCopiedCars().forEach(ResultView::printCarRunState);
        System.out.println();
    }

    public static void printWinners(List<SimpleCar> winners) {
        String winnersString = winners.stream().map(SimpleCar::getCarName).collect(Collectors.joining(", "));
        System.out.println(winnersString + "가 최종 우승했습니다.");
    }

    private static void printCarRunState(SimpleCar car) {
        System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
    }
}
