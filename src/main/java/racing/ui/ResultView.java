package racing.ui;

import racing.core.dto.TrackInfo;
import racing.core.dto.Trial;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private List<Trial> trials;
    private String winners;

    public ResultView(List<Trial> trials, List<String> namesOfWinners) {
        this.trials = trials;
        this.winners = joinNames(namesOfWinners);
    }

    private String joinNames(List<String> namesOfWinners) {
        return namesOfWinners.stream()
                .collect(Collectors.joining(","));
    }

    public void printResult() {
        trials.stream()
                .map(this::parseString)
                .forEach(System.out::println);
        System.out.println(winners + "가 최종 우승했습니다.");
    }

    private String parseString(Trial trial) {
        return trial.getTracks()
                .stream()
                .map(this::mapTrackInfoToString)
                .reduce("", String::concat);
    }

    private String mapTrackInfoToString(TrackInfo trackInfo) {
        String track = IntStream.range(0, trackInfo.getPosition())
                .mapToObj(position -> "-")
                .reduce("", String::concat);
        return String.format("%s : %s\n", trackInfo.getCarName(), track);
    }
}
