package view;

import domain.RaceRecord;

public class ResultView {
    public static void print(RaceRecord raceRecords) {
        System.out.println("실행 결과");
        System.out.println(raceRecords.getRecord());
        printWinners(raceRecords.getRaceWinners());
    }

    private static void printWinners(String winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }

}
