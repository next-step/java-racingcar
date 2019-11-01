package com.seok.racing.view;

import com.seok.racing.domain.*;

public class RacingGameOutputView {

    public static void print(GameResult result) {
        printRacingResult(result.getRacingResult());
        printWinner(result.getWinners());
    }

    private static void printWinner(Winners winners) {
        System.out.println(winners.toString());
    }

    private static void printRacingResult(RacingResult result) {
        for (Records records : result) {
            printRecords(records);
            System.out.println();
        }
    }

    private static void printRecords(Records records) {
        for (Record record : records) {
            System.out.println(record.toString());
        }
    }


}
