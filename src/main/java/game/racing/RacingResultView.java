package game.racing;

import game.ResultEntity;
import game.ResultView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : yusik
 * @date : 2019/10/29
 */
public class RacingResultView implements ResultView<RacingResult> {

    private static String MESSAGE_RESULT = "\n실행 결과";
    private static String PRINTABLE_SYMBOL = "-";

    @Override
    public void render(ResultEntity<RacingResult> entity) {

        RacingResult result = entity.getResult();
        List<String> rounds = getRounds(result.getTrackingLogs());

        System.out.println(MESSAGE_RESULT);
        rounds.forEach(System.out::println);
        System.out.println(result.getChampionNames() + "가 최종 우승했습니다.");
    }

    private List<String> getRounds(List<TrackingLog> logs) {
        List<String> executionResults = new ArrayList<>();
        int times = logs.get(0).getSize();
        for (int i = 0; i < times; i++) {
            executionResults.add(getRound(i, logs));
        }
        return executionResults;
    }

    private String getRound(int i, List<TrackingLog> logs) {
        StringBuilder sb = new StringBuilder();
        for (TrackingLog log : logs) {
            sb.append(log.getName())
                    .append("\t")
                    .append(getCarPositionLog(log.getPositionByTimes(i)))
                    .append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    private String getCarPositionLog(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(PRINTABLE_SYMBOL);
        }
        return sb.toString();
    }
}
