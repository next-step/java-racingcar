package autoracing.view;

import autoracing.domain.Car;
import autoracing.domain.RacingGame;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final int DEFAULT_TRACE_DISTANCE = 1;
    private final RacingGame racingGame;
    private final CharSequence traceSign;
    private final String resultTitle;


    public ResultView(RacingGame racingGame, CharSequence traceSign, String resultTitle) {
        this.racingGame = racingGame;
        this.traceSign = traceSign;
        this.resultTitle = resultTitle;
    }

    public void show() {
        System.out.println(resultTitle);
        IntStream.range(0, racingGame.getTotalRounds())
                .forEach(round -> System.out.println(renderRound(round)));
        System.out.println(renderAnnouncingWinners());
    }

    private String renderRound(int round) {
        return racingGame.getParticipants().stream()
                .map(car -> renderCarLocationWithName(car, round))
                .collect(Collectors.joining("\n"))
                + "\n";
    }

    private String renderCarLocationWithName(Car car, int round) {
        return String.format("%s : %s", car.getName(), renderCarLocation(car, round));
    }

    private String renderCarLocation(Car car, int round) {
        int distanceFromStartingLine = car.getLocation(round).getDistance() + DEFAULT_TRACE_DISTANCE;
        return String.join("", Collections.nCopies(distanceFromStartingLine, traceSign));
    }

    private String renderAnnouncingWinners() {
        return String.format("%s가 최종 우승했습니다.", renderWinners());
    }

    private String renderWinners() {
        return racingGame.getWinners().stream().map(Car::getName).collect(Collectors.joining(", "));
    }
}
