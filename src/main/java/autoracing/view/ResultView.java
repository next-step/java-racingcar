package autoracing.view;

import autoracing.domain.Car;
import autoracing.domain.RacingGame;

import java.util.Collections;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final int DEFAULT_TRACE_DISTANCE = 1;

    private final RacingGame racingGame;
    private final CharSequence traceSign;
    private final String resultTitle;
    private final WinnersRenderer winnersRenderer;

    public static class Builder {
        private static final String DEFAULT_TRACE_SIGN = "-";
        private static final String DEFAULT_RESULT_TITLE = "실행 결과";

        private RacingGame racingGame;
        private CharSequence traceSign;
        private String resultTitle;
        private Function<RacingGame, WinnersRenderer> winnersRendererSupplier;

        public Builder(RacingGame racingGame) {
            this.racingGame = racingGame;
            this.traceSign = DEFAULT_TRACE_SIGN;
            this.resultTitle = DEFAULT_RESULT_TITLE;
            this.winnersRendererSupplier = (game) -> new WinnersRenderer(game.getWinners());
        }

        public Builder racingGame(RacingGame racingGame) {
            this.racingGame = racingGame;
            return this;
        }

        public Builder traceSign(CharSequence traceSign) {
            this.traceSign = traceSign;
            return this;
        }

        public Builder resultTitle(String resultTitle) {
            this.resultTitle = resultTitle;
            return this;
        }

        public Builder winnersRenderer(Function<RacingGame, WinnersRenderer> thunk) {
            this.winnersRendererSupplier = thunk;
            return this;
        }

        public ResultView build() {
            return new ResultView(racingGame, traceSign, resultTitle, winnersRendererSupplier.apply(racingGame));
        }
    }

    public ResultView(RacingGame racingGame, CharSequence traceSign, String resultTitle, WinnersRenderer winnersRenderer) {
        this.racingGame = racingGame;
        this.traceSign = traceSign;
        this.resultTitle = resultTitle;
        this.winnersRenderer = winnersRenderer;
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
        return winnersRenderer.render();
    }
}
