package racinggame.view;

import racinggame.car.RacingCars;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ResultView {

    private static final String POSITION_BAR = "-";
    private static final String NEW_LINE = "\n";

    private ResultView() {
    }

    public static void showTitle() {
        System.out.println(NEW_LINE + "실행 결과");
    }

    public static void showCarPositions(RacingCars racingCars) {
        StringBuilder result = new StringBuilder();

        racingCars.getRacingCars()
                .forEach(racingCar -> {
                    result.append(getPrefixCarName(racingCar.getName()));
                    result.append(getCarPositionBar(racingCar.getPosition())).append(NEW_LINE);
                });

        System.out.println(result);
    }

    public static void showWinnerMessage(String carNames) {
        System.out.println(carNames + "가 최종 우승했습니다.");
    }

    private static String getPrefixCarName(String carName) {
        return carName + " : ";
    }

    private static String getCarPositionBar(int position) {
        return Stream.generate(() -> POSITION_BAR)
                .limit(position)
                .collect(Collectors.joining());
    }
}
