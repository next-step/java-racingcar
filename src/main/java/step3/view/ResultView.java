package step3.view;

import step3.domain.RacingCar;

public class ResultView {
    public static void printRacingCarsStatus(RacingCar[] racingCars) {
        for (RacingCar racingCar : racingCars) {
            StringBuilder status = new StringBuilder(racingCar.getName())
                    .append(" : ")
                    .append("-".repeat(racingCar.getDistance()));
            System.out.println(status);
        }
        System.out.println();
    }

    public static void title() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printWinners(String winnerNames) {
        StringBuilder sb = new StringBuilder()
                .append(winnerNames)
                .append("가 최종 우승했습니다.");
        System.out.println(sb);
    }
}
