package racingcar.domain;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.domain.car.Car;

public class RacingResult {

    private static String RESULT_LINE = "%s : ";
    private static String DASH = "-";
    private static StringBuilder stringBuilder;
    private Participants participants;

    public RacingResult(Participants participants) {
        this.participants = participants;
    }

    public void getResultView() {
        for (int i = 0; i < participants.count(); i++) {
            stringBuilder = new StringBuilder();

            int status = participants.get(i).getStatus();
            System.out.printf(RESULT_LINE, participants.get(i).getName());
            while (status-- > 0) {
                stringBuilder.append(DASH);
            }
            System.out.println(stringBuilder.toString());
        }
        System.out.println();
    }

    public void printWinners() {
        Stream<Car> winner = participants.getWinners();
        String winnersName = winner.map(Car::getName).collect(Collectors.joining(", "));

        System.out.println("최종 우승자: " + winnersName);
    }

    public void moveCarIfPositionChanged(int index, boolean bool) {
        if (bool) {
            participants.get(index).go();
        }
    }
}
