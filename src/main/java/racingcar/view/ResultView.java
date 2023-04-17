package racingcar.view;

import racingcar.domain.Record;
import racingcar.domain.Records;
import racingcar.domain.Winner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final String DASH = "-";
    private static final String RESULT = "실행 결과";

    public static void print(List<Records> records) {
        System.out.println(RESULT);

        for (Records record : records) {
            printRecord(record);
            System.out.println();
        }
    }

    /**
     * 라운드별 결과 출력
     * @param records
     */
    private static void printRecord(Records records) {
        for (Record record : records.getRecords()) {
            System.out.printf("%s : %s%n", record.getName(), printDistance(record.getDistance()));
        }
    }

    /**
     * 거리만큼 "-"를 출력
     * @param distance
     * @return
     */
    private static String printDistance(int distance) {
        return IntStream.range(0, distance)
                .mapToObj(i -> DASH)
                .collect(Collectors.joining());
    }

    /**
     * 우승자 출력
     * @param winner
     */
    public static void printWinner(Winner winner) {
        System.out.println(String.join(", ", winner.getWinners()) + "가 우승했습니다.");
    }
}
