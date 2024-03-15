package racing.view;

import racing.domain.RacingCars;
import racing.domain.RacingCar;

public class ResultView {
    private static final String HYPHEN = "-";
    private static final String COMMA = ",";
    private static final String LINE_BREAK = "\n";

    public static void printGameResultTitle() {
        System.out.println(LINE_BREAK + "실행 결과");
    }

    public static void printCarsCurrentPosition(RacingCars racingCars) {
        racingCars.getRacingCarList()
                .stream()
                .map(ResultView::toCurrentPositionString)
                .forEach(System.out::println);
        System.out.print(LINE_BREAK);
    }

    public static void printWinners(RacingCars racingCars) {
        System.out.println(joinWinnerNames(racingCars) + " 가 최종 우승했습니다.");
    }

    private static String joinWinnerNames(RacingCars racingCars) {
        return String.join(COMMA, racingCars.getWinnerNames());
    }

    private static String toCurrentPositionString(RacingCar racingCar) {
        return racingCar.getName() + " : " + positionToString(racingCar.getPosition());
    }

    private static String positionToString(int position) {
        return HYPHEN.repeat(Math.max(0, position));
    }
}
