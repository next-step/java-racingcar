package racingcar;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void printResult(RaceResult result) {
        System.out.println("실행 결과");
        printLaps(result);
        printWinners(result);
    }

    private static void printLaps(RaceResult result) {
        for (Lap lap : result.getLaps()) {
            printLap(lap);
            System.out.println();
        }
    }

    private static void printLap(Lap lap) {
        for (Record record : lap.getRecords()) {
            printDistance(record);
        }
    }

    private static void printDistance(Record record) {
        StringBuffer sb = new StringBuffer(record.getName());
        sb.append(" : ");
        for (int d = 0; d < record.getDistance(); d++) {
            sb.append('-');
        }
        System.out.println(sb);
    }

    private static void printWinners(RaceResult result) {
        List<String> names = new ArrayList<>();
        for (Record record : result.getBestRecords()) {
            names.add(record.getName());
        }
        System.out.println(String.join(",", names) + "가 최종 우승했습니다.");
    }
}
