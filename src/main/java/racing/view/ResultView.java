package racing.view;

import java.util.List;
import racing.domain.Car;

public class ResultView {

    public ResultView() {
    }

    public static void printRoundResult(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.roundResult()));
    }

    public static void printWinner(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 우승했습니다.");
    }
}
