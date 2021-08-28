package step3.util;

import step3.domain.Car;

import java.util.List;

public class ResultView {

    private static final String GAME_RESULT_HEADER = "실행결과";
    private static final String GAME_RESULT = "가 최종 우승했습니다.";
    private static final String COLON = " : ";
    private static final String DASH = "-";
    private static final String SEPARATOR = ", ";
    private static final int SUBSTRING_START_IDX = 0;
    private static final int SUBSTRING_LENGTH = 2;

    public void printDistance(List<Car> cars) {
        for(Car car : cars) {
            System.out.print(car.getName());
            System.out.print(COLON);
            printDistance(car.getDistance());
            printNewLine();
        }
    }

    private void printDistance(int distance) {
        for(int i = 0; i < distance; i++) {
            System.out.print(DASH);
        }
    }

    public void printGameResultHeader() {
        System.out.println(GAME_RESULT_HEADER);
    }

    public void printGameWinners(List<String> winners) {
        StringBuilder stringBuilder = new StringBuilder();

        for(String winner : winners) {
            stringBuilder.append(winner);
            stringBuilder.append(SEPARATOR);
        }

        System.out.print(stringBuilder.substring(SUBSTRING_START_IDX, stringBuilder.length() - SUBSTRING_LENGTH));
        System.out.println(GAME_RESULT);
    }

    public void printNewLine() {
        System.out.println();
    }
}
