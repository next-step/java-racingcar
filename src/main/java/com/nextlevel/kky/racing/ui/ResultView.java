package com.nextlevel.kky.racing.ui;

import com.nextlevel.kky.racing.dto.CarRaceResultDto;
import com.nextlevel.kky.racing.dto.CarRaceResultDto.*;

import java.util.List;

public class ResultView {

    public static void printCarRaceResultDto(CarRaceResultDto carRaceResultDto) {
        for (RoundResultDto roundResultDto : carRaceResultDto.getRacingResult()) {
            printRoundResultDto(roundResultDto);
        }
        printCarWinners(carRaceResultDto.getWinnerNames());
    }

    private static void printRoundResultDto(RoundResultDto roundResultDto) {
        for (CarPositionDto carPositionDto : roundResultDto.getCarPositionDtoList()) {
            System.out.print(carPositionDto.getCarName() + ": ");
            System.out.print("-".repeat(carPositionDto.getPosition() + 1));
            System.out.println();
        }
        System.out.println();
    }

    private static void printCarWinners(List<String> winnerNames) {
        System.out.print(String.join(",", winnerNames));
        System.out.println("가 최종 우승했습니다.");
    }
}
