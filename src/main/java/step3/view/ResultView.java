package step3.view;

import step3.domain.RacingCar;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String RESULT_TITLE = "==============";

    private ResultView() {
    }

    public static void printPosition(List<RacingCar> racingCars) {
        System.out.println(RESULT_TITLE);
        racingCars.stream()
                .map(RacingCar::toString)
                .forEach(System.out::println);
    }

    public static void printWinner(List<RacingCar> racingCars) {
        String winnerName = racingCars.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(" ,"));

        System.out.println(winnerName + "가 최종 우승했습니다.");
    }
}
