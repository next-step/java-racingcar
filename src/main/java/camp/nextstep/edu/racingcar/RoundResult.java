package camp.nextstep.edu.racingcar;

import java.util.ArrayList;
import java.util.List;

public class RoundResult {

    private List<DriveResult> driveResults;

    public RoundResult() {
        this.driveResults = new ArrayList<>();
    }

    public void report(DriveResult driveResult) {
        driveResults.add(driveResult);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (DriveResult driveResult : driveResults) {
            result.append(driveResult.toString()).append('\n');
        }
        return result.toString();
    }
}
