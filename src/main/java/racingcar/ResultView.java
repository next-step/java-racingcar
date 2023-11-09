package racingcar;

import java.util.List;

public class ResultView {
    public static void printRacingResult(Car car) {
        System.out.print(car.getName() + " : ");
        for (int j = 0; j < car.getPosition(); j++) {
            System.out.print('-');
        }
        System.out.println();
    }

    public static void printAsterisk() {
        System.out.println("*******************************************");
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(",", winners) + "가 최종 우승했습니다.");
    }
}
