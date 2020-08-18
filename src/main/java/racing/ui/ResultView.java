package racing.ui;

import racing.core.dto.Trial;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private List<Trial> trials;
    private String winners;

    public ResultView(List<Trial> trials, List<String> namesOfWinners) {
        this.trials = trials;
        this.winners = joinNames(namesOfWinners);
    }

    private String joinNames(List<String> namesOfWinners) {
        return namesOfWinners.stream().collect(Collectors.joining(","));
    }

    public void printResult() {
        for (Trial each : trials) {
            System.out.println(each);
        }
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
