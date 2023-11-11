package step3.dto;

import java.util.List;

public class OutputDTO {
    private String racingLog;
    private List<String> winners;

    public OutputDTO(String racingLog, List<String> winners) {
        this.racingLog = racingLog;
        this.winners = winners;
    }

    public String getRacingLog() {
        return racingLog;
    }

    public void setRacingLog(String racingLog) {
        this.racingLog = racingLog;
    }

    public List<String> getWinners() {
        return winners;
    }

    public void setWinners(List<String> winners) {
        this.winners = winners;
    }
}
