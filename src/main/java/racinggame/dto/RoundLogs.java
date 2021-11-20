package racinggame.dto;

import racinggame.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RoundLogs {
    List<RoundLog> roundLogs = new ArrayList<>();;

    public RoundLogs(List<Car> cars) {
        for (Car car : cars) {
            this.roundLogs.add(RoundLog.from(car));
        }
    }

    private void addRoundLog(RoundLog roundLog){
        this.roundLogs.add(roundLog);
    }

    public List<RoundLog> getRoundLogs() {
        return roundLogs;
    }
}
