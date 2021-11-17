package racinggame.dto;

import java.util.ArrayList;
import java.util.List;

public class RoundLogs {
    List<RoundLog> roundLogs;

    public RoundLogs() {
        this.roundLogs = new ArrayList<>();
    }

    public void addRoundLog(RoundLog roundLog){
        this.roundLogs.add(roundLog);
    }

    public List<RoundLog> getRoundLogs() {
        return roundLogs;
    }
}
