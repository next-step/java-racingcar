package carracing.view;

import carracing.domain.Position;
import carracing.domain.RacingCar;
import carracing.domain.RacingResult;

public class ResultView {
    public static void printResult(RacingResult result) {
        for (RacingCar racingCar : result.getRacingCars()) {
            System.out.print(racingCar.getName() + " : ");
            printPosition(racingCar.getPosition());
        }
        System.out.println();
    }

    private static void printPosition(Position position) {
        for (int i = 0; i < position.value(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(RacingResult result) {
        System.out.println(String.join(", ", result.findWinners()) + "가 최종 우승했습니다.");
    }
}
