package racinggame;

import racinggame.ui.MessageWriter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGameResultView {
    private final String maker;
    private final List<RacingGameRound> rounds;
    private final MessageWriter writer;

    public RacingGameResultView(final String maker,
                                final List<RacingGameRound> rounds,
                                final MessageWriter writer
    ) {
        this.maker = maker;
        this.rounds = rounds;
        this.writer = writer;
    }

    public void result() {
        writer.write("실행 결과");
        processRounds();
    }

    private void processRounds() {
        final Map<RacingCar, Integer> carStatusMap = new HashMap<>();
        for (final RacingGameRound round : rounds) {
            processRacingCars(round, carStatusMap);
            displayRacingCars(round, carStatusMap);
            writer.write("");
        }
    }

    private void processRacingCars(final RacingGameRound round, final Map<RacingCar, Integer> carStatusMap) {
        for (final RacingCar racingCar : round.getRacingCars()) {
            updateCarStatus(round, carStatusMap, racingCar);
        }
    }

    private static void updateCarStatus(final RacingGameRound round, final Map<RacingCar, Integer> carStatusMap, final RacingCar racingCar) {
        if (round.isMove(racingCar)) {
            carStatusMap.put(racingCar, carStatusMap.getOrDefault(racingCar, 0) + 1);
            return;
        }

        carStatusMap.put(racingCar, carStatusMap.getOrDefault(racingCar, 0));
    }

    private void displayRacingCars(final RacingGameRound round, final Map<RacingCar, Integer> carStatusMap) {
        for (final RacingCar racingCar : round.getRacingCars()) {
            writer.write(repeatMaker(carStatusMap, racingCar));
        }
    }

    private String repeatMaker(final Map<RacingCar, Integer> carStatusMap, final RacingCar racingCar) {
        return maker.repeat(carStatusMap.get(racingCar));
    }
}
