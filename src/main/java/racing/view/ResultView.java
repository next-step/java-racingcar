package racing.view;

import racing.core.domain.Car;
import racing.core.dto.Trial;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final String TRACK = "-";
    private static final String DELIMITER = ",";

    private List<Trial> trials;
    private String winners;

    public ResultView(List<Trial> trials, List<Car> winners) {
        this.trials = trials;
        this.winners = joinNames(winners);
    }

    private String joinNames(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER));
    }

    public void printResult() {
        trials.stream()
                .map(this::parseString)
                .forEach(System.out::println);
        System.out.println(winners + "가 최종 우승했습니다.");
    }

    private String parseString(Trial trial) {
        return trial.getCarsAtThatTrial()
                .getCars()
                .stream()
                .map(this::mapCarToString)
                .reduce("", String::concat);
    }

    private String mapCarToString(Car car) {
        String track = IntStream.range(0, car.getPosition())
                .mapToObj(position -> TRACK)
                .reduce("", String::concat);
        return String.format("%s : %s\n", car.getName(), track);
    }
}
