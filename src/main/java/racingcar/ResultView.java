package racingcar;

import java.util.Arrays;
import java.util.stream.IntStream;

class ResultView {

    private void changeLines() {
        System.out.println();
    }

    private void printlnMessage(String message) {
        System.out.println(message);
    }

    private void printlnLaps(RacingCar racingCar) {
        String delimiter = " : ";
        String lapMart = "-";
        System.out.println(racingCar.getName() + delimiter + lapMart.repeat(racingCar.record()));
    }

    void printlnRace(RacingCar[] entries, int rounds) {
        changeLines();
        printlnMessage("실행결과");
        IntStream.range(0, rounds).forEach(round -> {
            Arrays.stream(entries)
                    .peek(RacingCar::race)
                    .forEach(this::printlnLaps);
            changeLines();
        });
    }

    void printlnWinners(RacingCar[] entries) {
        String delimiter = ", ";
        String message = "이(가) 최종 우승했습니다.";
        int winningLaps = Arrays.stream(entries)
                .map(RacingCar::record)
                .max(Integer::compare)
                .get();
        String winners = Arrays.stream(entries)
                .filter(racingCar -> racingCar.record() == winningLaps)
                .map(RacingCar::getName)
                .reduce((accumulator, combiner) -> accumulator + delimiter + combiner)
                .get();
        printlnMessage(winners + message);
    }
}
