package game.racing.view;

import game.core.domain.ResultEntity;
import game.core.view.ResultView;
import game.racing.domain.RacingResult;
import game.racing.domain.TrackingLog;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : yusik
 * @date : 2019/10/29
 */
public class RacingResultView implements ResultView<RacingResult> {

    private static String MESSAGE_RESULT = "\n실행 결과";
    private static String PRINTABLE_SYMBOL = "-";
    private static String NAME_DELIMITER = ", ";

    @Override
    public void render(ResultEntity<RacingResult> entity) {

        RacingResult result = entity.getResult();
        List<String> rounds = getRounds(result.getTrackingLogs());
        String championNames = getChampionNames(result.getMaxPositionLogs());

        System.out.println(MESSAGE_RESULT);
        rounds.forEach(System.out::println);
        System.out.println(championNames + "가 최종 우승했습니다.");
    }

    private String getChampionNames(List<TrackingLog> maxPositionLogs) {
        return maxPositionLogs.stream()
                .map(TrackingLog::getName)
                .collect(Collectors.joining(NAME_DELIMITER));
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
