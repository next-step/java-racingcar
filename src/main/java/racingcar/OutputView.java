package racingcar;

import java.util.List;

public class ResultView {

    private static final String DISTANCE_UNIT = "-";

    public static void askCarNumbers() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public static void askRoundNumbers() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public static String printDistance(List<Car> cars) {
        StringBuilder result = new StringBuilder();
        cars.stream().forEachOrdered(car -> {
            for (int i = 0; i < car.getDistance(); i++) {
                result.append(DISTANCE_UNIT);
            }
            result.append("\n");
        });
        return result.toString();
    }
}