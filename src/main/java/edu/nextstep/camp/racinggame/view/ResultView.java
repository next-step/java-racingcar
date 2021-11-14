package edu.nextstep.camp.racinggame.view;

import java.util.Collection;
import java.util.stream.Collectors;

import edu.nextstep.camp.racinggame.domain.car.Name;
import edu.nextstep.camp.racinggame.domain.car.Position;
import edu.nextstep.camp.racinggame.domain.race.Winners;

public class ResultView {
    private static final String TRACK = "#";
    private static final String TRIP = "-";
    private static final String CAR_DELIMITER = "\n";
    private static final String WINNER_DELIMITER = ",";

    private ResultView() {}

    public static void printResult(int turns, Collection<Position> gameResult) {
        final String track = TRACK.repeat(turns);
        final String result = gameResult.stream()
                .map(Position::toInt)
                .map(TRIP::repeat)
                .collect(Collectors.joining(CAR_DELIMITER));
        System.out.println(track);
        System.out.println(result);
        System.out.println(track);
    }

    public static void printWinners(Winners winners) {
        final String nameOfWinners = winners.stream()
                .map(Name::toString)
                .collect(Collectors.joining(WINNER_DELIMITER));
        System.out.println(nameOfWinners + "가 최종 우승했습니다.");
    }
}
