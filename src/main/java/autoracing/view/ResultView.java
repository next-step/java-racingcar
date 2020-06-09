package autoracing.view;

import autoracing.domain.Car;
import autoracing.domain.RacingGame;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final int NOT_INITIALIZED = -1;

    private final RacingGame racingGame;
    private final String resultTitle;
    private final WinnersRenderer winnersRenderer;
    private final CarTrackRenderer carTrackRenderer;
    private int maxNameSize = NOT_INITIALIZED;

    public static class Builder {
        private static final String DEFAULT_CAR_SIGN = "-";
        private static final String DEFAULT_TRACE_SIGN = "-";
        private static final String DEFAULT_STARTING_LINE = " : ";
        private static final String DEFAULT_RESULT_TITLE = "실행 결과";

        private RacingGame racingGame;
        private String resultTitle;
        private WinnersRenderer winnerRenderer;
        private CarTrackRenderer carTrackRenderer;

        public Builder(RacingGame racingGame) {
            this.racingGame = racingGame;
            this.resultTitle = DEFAULT_RESULT_TITLE;
            this.winnerRenderer = new WinnersRenderer();
            this.carTrackRenderer = new CarTrackRenderer(DEFAULT_CAR_SIGN, DEFAULT_STARTING_LINE, DEFAULT_TRACE_SIGN);
        }

        public Builder racingGame(RacingGame racingGame) {
            this.racingGame = racingGame;
            return this;
        }

        public Builder resultTitle(String resultTitle) {
            this.resultTitle = resultTitle;
            return this;
        }

        public Builder winnersRenderer(WinnersRenderer winnersRenderer) {
            this.winnerRenderer = winnersRenderer;
            return this;
        }

        public Builder carTrackRenderer(CarTrackRenderer carTrackRenderer) {
            this.carTrackRenderer = carTrackRenderer;
            return this;
        }

        public ResultView build() {
            return new ResultView(racingGame, resultTitle, winnerRenderer, carTrackRenderer);
        }
    }

    public ResultView(RacingGame racingGame, String resultTitle, WinnersRenderer winnersRenderer, CarTrackRenderer carTrackRenderer) {
        this.racingGame = racingGame;
        this.resultTitle = resultTitle;
        this.winnersRenderer = winnersRenderer;
        this.carTrackRenderer = carTrackRenderer;
    }

    public void show() {
        if (maxNameSize == NOT_INITIALIZED) {
            calculateMaxNameSize();
        }
        System.out.println(resultTitle);
        IntStream.range(0, racingGame.getTotalRounds())
                .forEach(round -> System.out.println(renderRound(round)));
        System.out.println(renderAnnouncingWinners());
    }

    private String renderRound(int round) {
        return racingGame.getParticipants().stream()
                .map(car -> renderCarTrack(car, round))
                .collect(Collectors.joining("\n"))
                + "\n";
    }

    private String renderCarTrack(Car car, int round) {
        return carTrackRenderer.render(car, round, maxNameSize);
    }

    private void calculateMaxNameSize() {
        this.maxNameSize = racingGame.getParticipants().stream()
                .map(participant -> participant.getName().length())
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("participants must not be empty."));
    }

    private String renderAnnouncingWinners() {
        return String.format("%s가 최종 우승했습니다.", renderWinners());
    }

    private String renderWinners() {
        return winnersRenderer.render(racingGame.getWinners());
    }
}
