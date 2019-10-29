package game.racing;

import game.Result;
import game.ResultView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : yusik
 * @date : 2019/10/29
 */
public class RacingResultView implements ResultView<TrackingLog> {

    private static String MESSAGE_RESULT = "\n실행 결과";
    private static String PRINTABLE_SYMBOL = "-";

    @Override
    public void render(Result<TrackingLog> result) {
        List<TrackingLog> logs = result.getExecutionResults();
        List<String> results = getResults(logs);

        System.out.println(MESSAGE_RESULT);
        results.forEach(System.out::println);
        System.out.println(getChampionNames(logs) + "가 최종 우승했습니다.");
    }

    private String getChampionNames(List<TrackingLog> logs) {

        // TODO: 29/10/2019 단일 반복으로 구하도록 고민해보기
        int maxPosition = logs.stream()
                .max(Comparator.comparingInt(TrackingLog::getLastPosition))
                .map(TrackingLog::getLastPosition).get();

        return logs.stream()
                .filter(trackingLog -> trackingLog.getLastPosition() == maxPosition)
                .map(TrackingLog::getName)
                .collect(Collectors.joining(", "));
    }

    private List<String> getResults(List<TrackingLog> logs) {
        List<String> executionResults = new ArrayList<>();
        int times = logs.get(0).getSize();
        for (int i = 0; i < times; i++) {
            executionResults.add(getResultString(i, logs));
        }
        return executionResults;
    }

    private String getResultString(int i, List<TrackingLog> logs) {
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
