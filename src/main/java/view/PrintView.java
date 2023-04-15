package view;

import vo.CarRecord;
import domain.record.Records;

import java.util.List;

public class PrintView {

    private PrintView() {}

    public static void printResult(Records records) {
        PrintView.printTitle();
        PrintView.printCar(records);
        PrintView.printWinners(records.winners());
    }

    public static void printTitle() {
        System.out.println("실행 결과");
    }

    public static void printCar(Records records) {
        List<CarRecord> gameRecord = records.gameRecord();

        for (CarRecord record : gameRecord) {
            System.out.print(record.name() + " : ");
            printDistance(record.distance());
        }
    }

    private static void printDistance(int distance) {
        System.out.print("-".repeat(distance));
        System.out.println();
    }

    public static void printWinners(List<CarRecord> winners) {
        for (CarRecord winner : winners) {
            System.out.print(winner.name() + ",");
        }

        System.out.println("가 최종 우승하셨습니다.");
    }
}
