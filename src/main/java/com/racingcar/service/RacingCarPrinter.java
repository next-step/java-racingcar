package com.racingcar.service;

import com.racingcar.model.RacingCar;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarPrinter {

    private static String FINAL_WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static String RACING_CAR_SHAPE = "-";
    private static String FINAL_WINNER_MESSAGE_JOINING = ",";
    private static String PRINT_SEPARATOR = " : ";

    public void printRacingCar(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            String racingCarName = racingCar.getRacingCarName();
            printRacingCarName(racingCarName);
            Integer racingCarStatus = racingCar.getRacingStatus();
            IntStream.range(0, racingCarStatus).forEach(j -> System.out.print(RACING_CAR_SHAPE));
            System.out.println();
        }

        System.out.println();
    }

    private void printRacingCarName(String racingCarName) {
        if (StringUtils.isNotEmpty(racingCarName)) {
            System.out.print(racingCarName + PRINT_SEPARATOR);
        }
    }

    public void printWinner(List<RacingCar> racingCars) {
        String finalWinnerMessage = CollectionUtils.emptyIfNull(racingCars)
                .stream()
                .map(RacingCar::getRacingCarName)
                .collect(Collectors.joining(FINAL_WINNER_MESSAGE_JOINING)) + FINAL_WINNER_MESSAGE;

        System.out.println(finalWinnerMessage);
    }
}
