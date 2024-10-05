package racinggame.view;

import racinggame.domain.RacingCar;
import racinggame.domain.RacingCars;
import racinggame.domain.RacingGameResult;
import racinggame.domain.RacingGameResults;

import java.util.stream.Collectors;

public class RacingGameResultView {
    private static final String MAKER = "-";

    private final RacingGameResults results;
    private final MessageWriter writer;

    public RacingGameResultView(final RacingGameResults results, final MessageWriter writer) {
        this.results = results;
        this.writer = writer;
    }

    public void display() {
        writer.write("실행 결과");

        for (final RacingGameResult result: results) {
            displayGameResult(result);
            writer.write("");
        }

        displayWinner();
    }

    private void displayWinner() {
        final RacingGameResult finalGameResult = results.last();
        final RacingCars winners = finalGameResult.winners();
        final String collect = winners.stream()
            .map(RacingCar::name)
            .collect(Collectors.joining(", "));
        writer.write(collect + "가 최종 우승했습니다.");
    }

    private void displayGameResult(final RacingGameResult result) {
        for (final RacingCar racingCar : result.getRacingCars()) {
            writer.write(racingCar.name() + ": " + MAKER.repeat(racingCar.currentPosition()));
        }
    }
}
