package step3.view;

import step3.domain.CarName;
import step3.domain.RacingCar;

import java.util.List;

public class ResultView {
    public static void printRacingCarsStatus(RacingCar[] racingCars) {
        for (RacingCar racingCar : racingCars) {
            StringBuilder status = new StringBuilder(racingCar.name().value())
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

    public static void printWinners(List<CarName> winnerNames) {
        StringBuilder sb = new StringBuilder();
        for (CarName winnerName : winnerNames) {
            sb.append(winnerName.value()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("가 최종 우승했습니다.");

        System.out.println(sb);
    }
}
