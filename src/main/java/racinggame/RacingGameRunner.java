package racinggame;

import racinggame.input.RacingCarInput;
import racinggame.input.RacingGameRoundInput;
import racinggame.ui.MessageReader;
import racinggame.ui.MessageWriter;
import racinggame.util.RacingGameRandomNumber;

import java.util.ArrayList;
import java.util.List;

public class RacingGameRunner implements GameRunner {
    private final MessageReader<Integer> reader;
    private final MessageWriter writer;

    public RacingGameRunner(final MessageReader<Integer> reader, final MessageWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void play() {
        writer.write("자동차 대수는 몇 대 인가요?");
        final RacingCarInput carInput = RacingCarInput.from(reader.read());

        writer.write("시도할 회수는 몇 회 인가요?");
        final RacingGameRoundInput roundInput = RacingGameRoundInput.from(reader.read());

        final List<RacingCar> racingCars = settingRacingCars(carInput);
        final List<RacingGameRound> rounds = settingRacingRounds(roundInput, racingCars);
        for (final RacingGameRound round : rounds) {
            round.start();
        }

        final RacingGameResultView resultView = new RacingGameResultView("-", rounds, writer);
        resultView.result();
    }

    private static List<RacingGameRound> settingRacingRounds(final RacingGameRoundInput roundInput, final List<RacingCar> racingCars) {
        final List<RacingGameRound> rounds = new ArrayList<>();
        for (int i = 0; i < roundInput.getRound(); i++) {
            rounds.add(new RacingGameRound(racingCars, new RacingGameRandomNumber()));
        }

        return rounds;
    }

    private List<RacingCar> settingRacingCars(final RacingCarInput racingCarInput) {
        final List<RacingCar> cars = new ArrayList<>();
        for (int i = 0; i < racingCarInput.getCarCount(); i++) {
            cars.add(new RacingCar(i + 1));
        }

        return cars;
    }
}
