package racingcar.view;

import java.util.List;

import static racingcar.view.InputMessages.ENTER_CAR_NAMES;
import static racingcar.view.InputMessages.ENTER_ROUNDS;

public class IOManager {

    private final Input input;
    private final Output output;

    public IOManager(final Input input, final Output output) {
        this.input = input;
        this.output = output;
    }

    public List<String> getCarNames() {
        output.println(ENTER_CAR_NAMES);
        return input.getCarNames();
    }

    public int getRounds() {
        output.println(ENTER_ROUNDS);
        return input.getRounds();
    }
}
