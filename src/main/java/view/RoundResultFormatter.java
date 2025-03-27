package view;

import domain.RacingCarCurrentStatus;

import java.util.List;

public class RoundResultFormatter {

    private final List<RacingCarCurrentStatus> racingCarStatuses;

    public RoundResultFormatter(List<RacingCarCurrentStatus> racingCarStatuses) {
        this.racingCarStatuses = racingCarStatuses;
    }

    public String formatCarStatuses() {
        StringBuilder result = new StringBuilder();
        for (RacingCarCurrentStatus status: racingCarStatuses) {
            result.append(formatCarStatus(status)).append("\n");
        }
        return result.toString();
    }

    private String formatCarStatus(RacingCarCurrentStatus status) {
        String dashes = "-".repeat(status.position().value() + 1);
        return status.name() + ":" + dashes;
    }
}
