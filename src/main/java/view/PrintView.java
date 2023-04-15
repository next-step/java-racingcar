package view;

import domain.record.Records;
import vo.CarRecord;

import java.util.List;

public class PrintView {

    private PrintView() {}

    public static void printResult(Records records, int trial) {
        PrintView.printTitle();
        PrintView.printCar(records, trial);
        PrintView.printWinners(records.winners());
    }

    public static void printTitle() {
        System.out.println("실행 결과");
    }

    public static void printCar(Records records, int trial) {
        List<CarRecord> gameRecord = records.gameRecord();
        int carCount = gameRecord.size() / trial;
        int recordCount = 0;

        for (CarRecord record : gameRecord) {
            recordCount++;
            System.out.print(record.name() + " : ");
            printDistance(record.distance());
            nextRound(carCount, recordCount);
        }
    }

    private static void printDistance(int distance) {
        System.out.println("-".repeat(distance));
    }

    private static void nextRound(int carCount, int round) {
        if (round % carCount == 0) {
            System.out.println();
        }
    }

    public static void printWinners(List<CarRecord> winners) {
        for (CarRecord winner : winners) {
            System.out.print(winner.name() + ",");
        }

        System.out.println("가 최종 우승하셨습니다.");
    }
}
