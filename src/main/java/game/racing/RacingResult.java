package game.racing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class RacingResult {

    private List<TrackingLog> logs;

    public RacingResult() {
        logs = new ArrayList<>();
    }

    public TrackingLog register(String name) {
        TrackingLog trackingLog = new TrackingLog(name);
        logs.add(trackingLog);
        return trackingLog;
    }

    public List<TrackingLog> getTrackingLogs() {
        return logs;
    }

    public List<TrackingLog> getMaxPositionLogs() {
        return logs.stream()
                .filter(log -> log.isMaxPosition(getMaxPosition()))
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return logs.stream()
                .max(Comparator.comparingInt(TrackingLog::getLastPosition))
                .map(TrackingLog::getLastPosition).get();
    }

}
