package racingcar.view;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

public class RacingCarOutput {

    private RacingCarOutput() {
    }

    private static final String SYSTEM_MESSAGE_FINAL_WINNER = "최종 우승자: ";
    private static final String REQUEST_MESSAGE_TRY_COUNT = "시도할 횟수는 몇 회인가요?";
    private static final String REQUEST_RACING_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    public static final String ERROR_CAR_NAME_OVER_OR_EMPTY = "자동차 이름의 길이가 5를 초과했거나 비어있습니다";
    public static final String ERROR_MESSAGE = "[ERROR] ";
    public static final String ERROR_REFLECTION = "리플렉션 중 에러 발생";
    public static final String ERROR_RANDOM_NUMBER_MAX_OVERFLOW = "끝값이 너무 큽니다. (스택 오버플로우 발생이 가능합니다)";
    public static final String ERROR_RANDOM_NUMBER_MAX_LIMIT = "입력값이 너무 큽니다.";
    public static final String ERROR_START_NOT_BIG_END = "startInclusive가 endInclusive보다 클 수 없습니다.";

    public static void printRequestCarName() {
        System.out.println(REQUEST_RACING_CAR_NAME);
    }

    public static void printRequestGameTry() {
        System.out.println(REQUEST_MESSAGE_TRY_COUNT);
    }

    public static void printExceptionMessage(String exceptionMessage) {
        System.out.println(ERROR_MESSAGE + exceptionMessage);
    }

    public static void printWinnersResult(List<String> gameWinner) {
        System.out.println(SYSTEM_MESSAGE_FINAL_WINNER + String.join(", ", gameWinner));
    }

    public static void printGameScore(final List<RacingCars> histories) {
        histories.forEach(racingCars -> printRacingCars(racingCars));
    }

    public static void printRacingCars(final RacingCars racingCars) {
        System.out.println();
        for (RacingCar car : racingCars.getRacingCars()) {
            printCar(car);
        }
    }

    public static void printCar(final RacingCar racingCar) {
        System.out.println(racingCar.getName() + " : " + convertPosition(racingCar.getPosition()));
    }

    private static String convertPosition(final int position) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
