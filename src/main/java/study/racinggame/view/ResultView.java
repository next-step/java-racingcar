package study.racinggame.view;

import study.racinggame.domain.Car;
import study.racinggame.domain.Cars;

import java.util.List;

public class ResultView {
    public static void printOutPositions(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.printf("%s : ", car.getName());
            int position = car.getPosition();
            for (int i = 0; i < position; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printOutWinner(List<String> winnerNames) {
        System.out.println("< 우승자 명단 >");
        for (String winnerName : winnerNames) {
            System.out.println(winnerName);
        }
    }
}
