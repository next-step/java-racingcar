package autoracing;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final int DEFAULT_TRACE_DISTANCE = 1;
    private final List<Car> cars;
    private final int totalRounds;
    private final CharSequence traceSign;
    private final String resultTitle;

    public ResultView(List<Car> cars, int totalRounds, CharSequence traceSign, String resultTitle) {
        this.cars = cars;
        this.totalRounds = totalRounds;
        this.traceSign = traceSign;
        this.resultTitle = resultTitle;
    }

    public void show() {
        System.out.println(resultTitle);
        IntStream.range(0, totalRounds)
                .forEach(round -> System.out.println(renderRound(round)));
    }

    private String renderRound(int round) {
        return cars.stream()
                .map(car -> renderCarLocation(car, round))
                .collect(Collectors.joining("\n"))
                + "\n";
    }

    private String renderCarLocation(Car car, int round) {
        int distanceFromStartingLine = car.getLocation(round).getDistance() + DEFAULT_TRACE_DISTANCE;
        return String.join("", Collections.nCopies(distanceFromStartingLine, traceSign));
    }
}
