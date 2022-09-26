package racingcar;

import java.util.List;

public class RacingGamePrinter {

    private static final String INIT_RACING_CAR_PHRASE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INIT_TRY_COUNT_PHRASE = "시도할 회수는 몇 회 인가요?";
    private static final String GAME_RESULT_MESSAGE = "실행 결과";
    private static final String RACING_CAR_POSITION_EXPRESSION = "-";
    private static final String RACING_CAR_WINNER_RESULT_MESSAGE = "가 최종 우승했습니다.";

    public static void printInitRacingCarPhrase() {
        System.out.println(INIT_RACING_CAR_PHRASE);
    }

    public static void printInitTryCountPhrase() {
        System.out.println(INIT_TRY_COUNT_PHRASE);
    }

    public static void printGameResultMessage() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public static void printRacingCarsPositionExpression(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            printRacingCarPositionExpression(racingCar.getName(), racingCar.getPosition());
        }
        System.out.println();
    }

    private static void printRacingCarPositionExpression(String name, int count) {
        System.out.print(name + " : ");
        for (int i = 0; i < count; i++) {
            System.out.print(RACING_CAR_POSITION_EXPRESSION);
        }
        System.out.println();
    }

    public static void printRacingCarWinnerResult(String[] names) {
        System.out.println(String.join(", ", names) + RACING_CAR_WINNER_RESULT_MESSAGE);
    }
}
