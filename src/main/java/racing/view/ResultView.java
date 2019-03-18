package racing.view;

import racing.domain.RacingCar;

import java.util.List;

public class ResultView {
    public static void printResult(List<RacingCar> racingCars) {
        System.out.println();
        racingCars.forEach(racingCar -> {
            System.out.println(racingCar.toString());
        });
    }

    public static void printWinner(List<String> winners) {
        System.out.print(String.join(", ", winners) + " 가(이) 최종 우승했습니다.");
    }
}
