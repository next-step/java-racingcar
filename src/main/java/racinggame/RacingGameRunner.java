package racinggame;

import racinggame.input.RacingCarInput;
import racinggame.input.RacingGameInputView;
import racinggame.input.RacingTryCountInput;
import racinggame.ui.MessageReader;
import racinggame.ui.MessageWriter;

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
        final RacingTryCountInput tryCountInput = RacingTryCountInput.from(reader.read());

        final RacingGameInputView inputView = new RacingGameInputView(carInput, tryCountInput);
        final List<RacingCar> racingCars = inputView.createRacingCars();

        final RacingGameResultView racingGameResultView = new RacingGameResultView("-", racingCars, writer, tryCountInput);
        racingGameResultView.result();
    }
}
