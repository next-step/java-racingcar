package racingcargamefinal.ui;

import racingcargamefinal.domain.Cars;
import racingcargamefinal.domain.Winners;

public class ResultView {

    public static final String RESULT_MESSAGE = "실행 결과";
    public static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printResult(Cars cars) {
        cars.getCars().stream()
                .forEach(car -> {
                    System.out.println(car.getName().getValue() + " : " + changeIntToCharacter(car.getPosition().getValue(), '-'));
                });
        System.out.println();
    }

    private static String changeIntToCharacter(int value, char character) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value; i++) {
            sb.append(character);
        }
        return sb.toString();
    }

    public static void printWinners(Winners winners) {
        System.out.printf(WINNER_MESSAGE, winners.toString());
    }

}
