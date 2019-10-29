package com.seok.racing.view;

import com.seok.racing.domain.Car;
import com.seok.racing.domain.RacingGame;
import com.seok.racing.utils.StringUtils;
import java.text.MessageFormat;
import java.util.stream.IntStream;

public class RacingGameOutputView {

    private final static String LOCATION_SYMBOL = "-";
    private final static String PRINT_WINNER = "{0}가 최종 우승했습니다.";
    private final static String PRINT_LOCATION = "{0} : {1}";
    private final static String WINNER_DELIMITER = ", ";


    private final RacingGame racingGame;

    public RacingGameOutputView(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void printWinner() {
        System.out.println(MessageFormat.format(PRINT_WINNER, formatWinner()));
    }

    private String formatWinner() {
        return String.join(WINNER_DELIMITER, racingGame.getCars().getWinners());
    }

    public void printRecords() {
        IntStream.range(0, racingGame.getTimes()).forEach(this::printRecord);
    }

    private void printRecord(final int idx) {
        racingGame.getCars()
            .stream()
            .forEach(car -> System.out.println(formatLocation(car, idx)));
        System.out.println();
    }

    private String formatLocation(Car car, int idx) {
        return MessageFormat
            .format(PRINT_LOCATION, car.getName(), StringUtils.repeat(LOCATION_SYMBOL, car.getRecord().getCumulativeDistance(idx)));
    }
}
