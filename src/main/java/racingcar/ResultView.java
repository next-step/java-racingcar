package racingcar;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행결과";
    private static final String LAPS_DELIMITER = " : ";
    private static final String LAP_MART = "-";
    private static final String WINNERS_DELIMITER = ", ";
    private static final String WINNERS_MESSAGE = "이(가) 최종 우승했습니다.";
    private static final int BEGIN_INDEX = 0;

    private void changeLines() {
        System.out.println();
    }

    private void printlnMessage(String message) {
        System.out.println(message);
    }

    private void printlnLaps(RacingCar racingCar) {
        System.out.println(racingCar.getName() + LAPS_DELIMITER + LAP_MART.repeat(racingCar.record()));
    }

    void printlnRace(Track track) {
        changeLines();
        printlnMessage(RESULT_MESSAGE);
        IntStream.range(BEGIN_INDEX, track.getRounds()).forEach(round -> {
            track.race();
            Arrays.stream(track.getEntries())
                    .forEach(this::printlnLaps);
            changeLines();
        });
    }

    void printlnWinners(String[] winners) {
        String winnersString = Arrays.stream(winners)
                .reduce((accumulator, combiner) -> accumulator + WINNERS_DELIMITER + combiner)
                .orElseThrow(NoSuchElementException::new);
        printlnMessage(winnersString + WINNERS_MESSAGE);
    }
}
