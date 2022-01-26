package racingcar.view;

import java.util.List;
import racingcar.domain.RacingCar;

public class ResultView {

    private ResultView() {
    }

    public static void printCars(List<RacingCar> cars) {
        cars.forEach(System.out::println);
        System.out.println("------------------------------");
    }

    public static void printWinners(List<String> winners) {
        System.out.print("최종 우승자: " + String.join(", ", winners));
    }

}
