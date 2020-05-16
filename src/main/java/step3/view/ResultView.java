package step3.view;

import step3.domain.RacingCar;

import java.util.List;

public class ResultView {

    private static final String RESULT_TITLE = "======= 실행 결과 =======";

    private ResultView() {
    }

    public static void printPosition(List<RacingCar> racingCars) {
        System.out.println(RESULT_TITLE);
        racingCars.stream()
                .map(RacingCar::toString)
                .forEach(System.out::println);
    }
}
