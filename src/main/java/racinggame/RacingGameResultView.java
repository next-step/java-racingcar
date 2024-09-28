package racinggame;

import racinggame.input.RacingTryCountInput;
import racinggame.ui.MessageWriter;
import racinggame.utils.RacingGameUtils;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameResultView {
    private final String maker;
    private final List<RacingCar> racingCars;
    private final MessageWriter writer;
    private final RacingTryCountInput tryCount;

    public RacingGameResultView(final String maker,
                                final List<RacingCar> racingCars,
                                final MessageWriter writer,
                                final RacingTryCountInput tryCount
    ) {
        this.maker = maker;
        this.racingCars = racingCars;
        this.writer = writer;
        this.tryCount = tryCount;
    }

    public void result() {
        writer.write("실행 결과");
        processTrials();
    }

    private void processTrials() {
        for (int i = 0; i < tryCount.getTrials(); i++) {
            processRacingCars();
            writer.write("");
        }
    }

    private void processRacingCars() {
        for (final RacingCar racingCar : racingCars) {
            racingCar.isMove(RacingGameUtils.generateRandomNumber());
            writer.write(convertHistoriesToMaker(racingCar.currentHistories()));
        }
    }

    private String convertHistoriesToMaker(final List<Boolean> histories) {
        return histories.stream()
            .filter(b -> b)
            .map(b -> maker)
            .collect(Collectors.joining());
    }
}
