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
        for (Distance distance : lap.getDistances()) {
            printDistance(distance);
        }
    }

    private static void printDistance(Distance distance) {
        StringBuffer sb = new StringBuffer();
        for (int d = 0; d < distance.getDistance(); d++) {
            sb.append('-');
        }
        System.out.println(sb);
    }
}
