package racingcar;

import java.util.List;

public class ResultView {

    public static void printCars(List<RacingCar> racingCars) {
        racingCars.forEach(racingCar -> System.out.println(racingCar.toString()));
    }

    public static void printWinners(GameResult result){
        System.out.println(result.winner() + "가 최종 우승했습니다.");
    }
}
