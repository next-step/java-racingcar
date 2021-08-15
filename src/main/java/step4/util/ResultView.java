package step4.util;

import step4.domain.Car;

import java.util.List;

public class ResultView {

    private final String GAME_RESULT_HEADER = "실행결과";
    private final String GAME_RESULT = "가 최종 우승했습니다.";

    private final String DASH = "-";
    private final String COLON = " : ";
    private final String COMMA = ", ";

    public void printDistance(List<Car> cars) {
        for(Car car : cars) {
            System.out.print(car);
            System.out.print(COLON);
            System.out.println(car.getDistance());
        }
    }

    public void printGameResultHeader() {
        System.out.println(GAME_RESULT_HEADER);
    }

    public void printGameWinners(List<String> winners) {
        StringBuilder sb = new StringBuilder();

        for(String winner : winners) {
            sb.append(winner);
            sb.append(COMMA);
        }

        System.out.print(sb.substring(0, sb.length() - 2));
        System.out.println(GAME_RESULT);
    }

    public void printNewLine() {
        System.out.println();
    }
}
