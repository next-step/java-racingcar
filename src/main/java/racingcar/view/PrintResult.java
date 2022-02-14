package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.RacingCar;

public class PrintResult {

    public static final String DASH = "-";
    public static final String COMMA = ", ";
    public static final String WINNERS_IS = "최종 우승자: ";

    public static void printMoveState(List<RacingCar> racingCar) {
        racingCar.forEach(car -> {
            System.out.print(car.getCarName() + ": ");

            printCarDist(car.getCarDist());
        });

        System.out.println();
    }

    public static void printCarDist(int dist) {
        do {
            System.out.print(DASH);
            dist--;
        } while (dist > 0);

        System.out.println();
    }

    public static void printGameResult(List<RacingCar> winners) {
        System.out.println(WINNERS_IS + winners.stream()
            .map(RacingCar::getCarName)
            .collect(Collectors.joining(COMMA)));
    }
}
