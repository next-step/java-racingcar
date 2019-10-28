package com.seok.racing.view;

import com.seok.racing.domain.Car;
import com.seok.racing.domain.Cars;
import com.seok.racing.domain.RacingGame;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.stream.IntStream;

public class RacingGameOutputView {

    private final static String CAR_LOCATION_SYMBOL = "-";
    private final static String DELIMITER = "";
    private final static String PRINT_WINNER = "{0}가 최종 우승했습니다.";
    private final static String PRINT_LOCATION = "{0} : {1}";


    private final RacingGame racingGame;

    public RacingGameOutputView(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void printWinner() {
        System.out.println(MessageFormat.format(PRINT_WINNER, String.join(", ", racingGame.getCars().getWinner())));
    }

    public void printRecords() {
        IntStream.range(0,racingGame.getTimes()).forEach(i -> printRecord());
    }

    private void printRecord() {
        racingGame.getCars()
            .stream()
            .forEach(car -> System.out.println(formatLocation(car)));
        System.out.println();
    }

    private String formatLocation(Car car) {
        return MessageFormat.format(PRINT_LOCATION, car.getName(),String.join(DELIMITER, Collections.nCopies(car.getRecord().poll(), CAR_LOCATION_SYMBOL)));
    }
}
