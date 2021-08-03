package racingcar.view;

import racingcar.domain.MovingRecord;
import racingcar.domain.Position;
import racingcar.domain.RaceResult;

import java.util.List;
import java.util.stream.IntStream;


public class ResultView {
    private static final String INDICATION = "-";
    private static final String DELIMITER = ", ";

    public static void print(RaceResult raceResult) {
        System.out.println("실행 결과");
        IntStream.rangeClosed(1, raceResult.getRoundCount())
                .forEach((round) -> printCars(raceResult.getMovingRecords(), round));
        printWinners(raceResult.findWinners());
    }

    private static void printCars(List<MovingRecord> movingRecords, int round) {
        for (MovingRecord movingRecord : movingRecords) {
            System.out.print(movingRecord.getCarName() + " : ");

            List<Position> positions = movingRecord.getPositions();
            Position currentPosition = positions.get(round-1);
            printIndication(currentPosition.getPosition());
        }
        System.out.println();
    }

    private static void printIndication(int position) {
        IntStream.range(0, position).forEach((index) -> System.out.print(INDICATION));
        System.out.println();
    }

    private static void printWinners(List<String> winners) {
        System.out.print(String.join(DELIMITER, winners));
        System.out.println("가 최종 우승했습니다.");
    }
}
