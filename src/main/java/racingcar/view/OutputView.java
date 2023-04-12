package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winner;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static final String POSITION_VIEW = "-";

    public static void endMessage() {
        System.out.println("실행 결과");
    }

    public static void gameResult(Cars cars) {
        for (Car car : cars.cars()) {
            System.out.println(viewResult(car));
        }
        System.out.println();
    }

    private static String viewResult(Car car) {
        return car.name() + " : "+ viewPosition(car.positionNumber());
    }

    private static String viewPosition(int position) {
        return POSITION_VIEW.repeat(Math.max(0, position));
    }

    public static void gameWinner(Winner winner) {
        List<Car> winnerCars = winner.winnerCars();
        String winnerNames = winnerCars.stream().map(Car::name).collect(Collectors.joining(","));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
