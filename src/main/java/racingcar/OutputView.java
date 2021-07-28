package racingcar;

public class OutputView {
    public static void printResult(RaceResult result) {
        System.out.println("실행 결과");
        for (Lap lap : result.getLaps()) {
            for (int distance : lap.getDistances()) {
                StringBuffer sb = new StringBuffer();
                for (int d = 0; d < distance; d++) {
                    sb.append('-');
                }
                System.out.println(sb);
            }
            System.out.println();
        }
    }
}
