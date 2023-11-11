package racingcar.view;

import racingcar.domain.Car;

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

    public static void printWinners(String winnerNames) {
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
