package racingcar;

import java.util.List;

public class ResultView {

    public static void printCars(List<RacingCar> racingCars) {
        racingCars.forEach(racingCar -> System.out.println(racingCar.toString()));
    }

    //우승자 출력
    public static void printWinners(String winner){
        System.out.println(winner + "가 최종 우승했습니다.");
    }
}
