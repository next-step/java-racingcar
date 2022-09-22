package racingcar;

import java.util.List;

public class RacingGamePrinter {

    private static final String INIT_CAR_COUNT_PHRASE = "자동차 대수는 몇 대 인가요?";
    private static final String INIT_TRY_COUNT_PHRASE = "시도할 회수는 몇 회 인가요?";
    private static final String GAME_RESULT_MESSAGE = "실행 결과";
    private static final String RACING_CAR_POSITION_EXPRESSION = "-";

    public static void printInitCarCountPhrase() {
        System.out.println(INIT_CAR_COUNT_PHRASE);
    }

    public static void printInitTryCountPhrase() {
        System.out.println(INIT_TRY_COUNT_PHRASE);
    }

    public static void printGameResultMessage() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public static void printRacingCarsPositionExpression(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            printRacingCarPositionExpression(racingCar.getPosition());
        }
        System.out.println();
    }

    private static void printRacingCarPositionExpression(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(RACING_CAR_POSITION_EXPRESSION);
        }
        System.out.println();
    }
}
