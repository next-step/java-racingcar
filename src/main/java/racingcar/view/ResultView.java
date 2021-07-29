package racingcar.view;

import racingcar.dto.Board;
import racingcar.domain.Name;
import racingcar.domain.Position;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String CAR_POSITION_DISPLAY = "-";
    private static final String COMMA = ",";

    public static void printCurrentRace(Board board) {
        List<Position> currentRacingCarPositions = board.getRacingCarPositions();
        List<Name> currentCarNames = board.getRacingCarNames();

        for (int i = 0; i < currentRacingCarPositions.size(); i++) {
            appendCarPosition(currentCarNames.get(i), currentRacingCarPositions.get(i));
        }
        System.out.println();

    }

    public static void printWinners(List<Name> winners) {

        System.out.print(winners.stream()
                .map(winner -> winner.toString())
                .collect(Collectors.joining(COMMA)));

        System.out.print(" 가 최종 우승했습니다.");
    }

    private static void appendCarPosition(Name carName, Position carPosition) {

        StringBuilder sb = new StringBuilder();
        Position p1 = new Position();
        while (!p1.equals(carPosition)) {
            sb.append(CAR_POSITION_DISPLAY);
            p1.move();
        }
        System.out.println(carName + " : " + sb);

    }

}
