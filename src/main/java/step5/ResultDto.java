package step5;

import java.util.ArrayList;
import java.util.List;

public class ResultDto {
    private List<Cars> racingLog;
    private List<String> winners;


    public ResultDto() {
        this.racingLog = new ArrayList<>();
    }

    public ResultDto(List<Cars> racingLog, List<String> winners) {
        this.racingLog = racingLog;
        this.winners = winners;
    }


    public void logScore(Cars cars) {
        racingLog.add(Cars.of(cars));
    }

    public void setWinners(List<String> winners) {
        this.winners = winners;
    }

    public List<Cars> getRacingLog() {
        return racingLog;
    }

    public List<String> getWinners() {
        return winners;
    }
}
