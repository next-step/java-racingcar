package racingcar.domain.dto;

import java.util.List;

public class RoundResult {

    private final List<DriveResult> driveResults;

    public RoundResult(List<DriveResult> driveResults) {
        this.driveResults = driveResults;
    }

    public List<DriveResult> driveResults() {
        return driveResults;
    }
}
