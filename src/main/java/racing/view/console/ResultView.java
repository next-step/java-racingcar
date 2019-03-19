package racing.view.console;

import racing.domain.Car;
import racing.domain.RacingResult;

import java.util.List;

public class ResultView {

    public static void printResult(RacingResult result) {
        System.out.println(result.toString());
    }

    public static void printWinners(RacingResult result) {
        List<Car> cars = result.getWinners();

        for (Car car : cars) {
            System.out.print(car.getName() + ",");
        }
        System.out.println("가 최종 우승했습니다.");
    }
}
