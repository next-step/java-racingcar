package racingcar.view;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Participants;

public class OutputView {

    private static final String ENTER = "\n";
    private static final String HEAD_MESSAGE = ENTER + "실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자: ";
    private static final String RESULT_LINE = "%s : %s" + ENTER;
    private static final String DASH = "-";

    public static void printMessage(final String message) {
        System.out.print(message);
    }

    public static void printRacingResult(final List<Participants> racingResult) {
        StringBuilder raceRecord = new StringBuilder();

        for (Participants participants : racingResult) {
            appendRecord(raceRecord, participants.getParticipants());
        }

        System.out.println(HEAD_MESSAGE);
        printMessage(raceRecord.toString());
    }

    private static void appendRecord(StringBuilder raceRecord, List<Car> cars) {
        cars.forEach(car
            -> raceRecord.append(String.format(RESULT_LINE, car.getName(), convertPositionToDashString(car.getPosition()))));
        raceRecord.append(ENTER);
    }

    private static String convertPositionToDashString(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(DASH);
        }
        return sb.toString();
    }

    public static void printWinner(final String winner) {
        System.out.println(FINAL_WINNER_MESSAGE + winner);
    }
}
