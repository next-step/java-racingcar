package step3.controller;

import java.util.List;
import java.util.stream.IntStream;

public class ResultController {

    private static final String RACING_DASH = "-";
    private static final String NEW_LINE = "\n";

    public void printRacingLog(List<Integer> racingStepResult) {
        System.out.println(makeRacingResult(racingStepResult));
    }

    public String makeRacingResult(List<Integer> racingStepResult) {
        StringBuilder sb = new StringBuilder();
        racingStepResult
                .stream()
                .forEach(
                        location -> {
                            sb.append(makeLocationString(location));
                            sb.append(NEW_LINE);
                        }
                );
        return sb.toString();
    }

    public String makeLocationString(int location) {
        StringBuilder sb = new StringBuilder();
        IntStream
                .range(0, location)
                .forEach(i -> sb.append(RACING_DASH));
        return sb.toString();
    }

}
