package racingcar.UI;

import java.util.Arrays;
import racingcar.Car;

public class ResultView {

    public static void printResultString() {
        System.out.println("실행 결과\n");
    }

    public static void printRound(Car[] cars) {
        Arrays.stream(cars).forEach(car -> {
            System.out.print("-".repeat(car.getPosition()));
            System.out.println();
        });
        System.out.println();
    }

}
