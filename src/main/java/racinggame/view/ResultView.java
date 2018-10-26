package racinggame.view;


import racinggame.domain.Car;
import racinggame.domain.RacingResult;
import racinggame.utils.StringUtils;

public class ResultView {
    private static final String DASH = "-";

    public static void printResult(RacingResult result) {
        System.out.println("실행 결과");
        for ( Car car: result.getCars() ) {
            System.out.println(String.format("%s: %s", car.getName(), StringUtils.repeat(DASH, car.getPosition())));
        }
        System.out.println(String.format("%s가 최종 우승했습니다", result.createDisplayWinnerNames()));
    }
}
