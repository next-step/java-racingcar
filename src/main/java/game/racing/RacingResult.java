package game.racing;

import game.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class RacingResult implements Result<TrackingLog> {

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
    public List<TrackingLog> getExecutionResults() {
        return logs;
    }

}
