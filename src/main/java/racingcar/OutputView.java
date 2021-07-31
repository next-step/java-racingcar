package racingcar;

public class OutputView {
    public static void printResult(RaceResult result) {
        System.out.println("실행 결과");
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
}
