package racingcar;

import java.util.List;

public class ResultView {

    private ResultView() {
        throw new AssertionError();
    }

    public static void printFirstLine() {
        System.out.println("실행 결과");
    }

    public static void printGameResult(List<Car> cars) {
        for (Car car: cars) {
            System.out.println(car.getName() + " : " + getLengthString(car.getPosition()));
        }
        System.out.println();
    }

    private static String getLengthString(int length) {
        return "-".repeat(length);
    }

    public static void printWinners(List<String> winnerNames) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(winnerNames.get(0));

        for (int i = 1; i < winnerNames.size(); i++) {
            stringBuilder.append(", ").append(winnerNames.get(i));
        }

        stringBuilder.append("가 최종 우승했습니다.");
        System.out.println(stringBuilder);
    }
}
