package camp.nextstep.edu.racingcar.domain.result;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoundResult {

    private final List<DriveResult> driveResults;

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

    public List<DriveResult> driveResults() {
        return driveResults;
    }

    public List<String> getWinners() {
        int maxDrivenDistance = getMaxDrivenDistance();
        return driveResults.stream()
            .filter(driveResult -> driveResult.drivenDistance() == maxDrivenDistance)
            .map(DriveResult::name)
            .collect(Collectors.toList());
    }

    private int getMaxDrivenDistance() {
        return driveResults.stream()
            .map(DriveResult::drivenDistance)
            .max(Integer::compareTo)
            .orElseThrow();
    }
}
