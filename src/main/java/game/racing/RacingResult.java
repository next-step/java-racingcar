package game.racing;

import game.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class RacingResult implements Result {

    private List<TrackingLog> logs;

    public RacingResult() {
        logs = new ArrayList<>();
    }

    public TrackingLog register(String name) {
        TrackingLog trackingLog = new TrackingLog(name);
        logs.add(trackingLog);
        return trackingLog;
    }

    @Override
    public List<String> getExecutionResults() {

        List<String> executionResults = new ArrayList<>();
        int times = logs.get(0).getSize();
        for (int i = 0; i < times; i++) {
            executionResults.add(getResultString(i));
        }
        return executionResults;
    }

    private String getResultString(int i) {
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
            sb.append("-");
        }
        return sb.toString();
    }
}
