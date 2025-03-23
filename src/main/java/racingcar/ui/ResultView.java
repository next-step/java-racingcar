package racingcar.ui;

import racingcar.domain.Car;
import racingcar.domain.RoundResult;

import java.util.List;

public class ResultView {

    public static void viewRacingCarWinner(List<String> winners) {
        System.out.println(String.join(",", winners) + "가 최종 우승했습니다.");
    }

    public static void viewRoundResults(List<RoundResult> roundResults) {
        System.out.println("실행 결과");
        for (RoundResult result : roundResults) {
            for (Car car : result.getCarStatus()) {
                System.out.println("-".repeat(car.getPosition()));
            }
            System.out.println();
        }
    }

    public static void viewRoundResultsWithName(List<RoundResult> roundResults) {
        System.out.println("실행 결과");
        for (RoundResult result : roundResults) {
            for (Car car : result.getCarStatus()) {
                System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
            }
            System.out.println();
        }
    }

}
