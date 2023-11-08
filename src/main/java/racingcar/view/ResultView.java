package racingcar.view;

import racingcar.domain.Cars;

public class ResultView {

    public static void printResultStart() {
        System.out.println("\n실행 결과");
    }

    public static void printResult(Cars cars) {
        for (String status: cars.carStatuses()) {
            System.out.println(status);
        }

        System.out.println();
    }


    public static void printWinners(Cars cars) {
        String result = String.join(",", cars.winnerNames()) + "가 최종 우승했습니다.";
        System.out.println(result);
    }
}
