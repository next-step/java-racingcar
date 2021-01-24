package racingcar;

import racingcar.input.Input;
import racingcar.input.KeyboardInput;

import java.util.List;

import static racingcar.input.InputMessages.ENTER_CAR_NAMES;
import static racingcar.input.InputMessages.ENTER_ROUNDS;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        Input input = new KeyboardInput(System.in);
        Output output = new ConsoleOutput();
        List<String> carNames = getCarNames(input, output);
        int rounds = getRounds(input, output);
        RacingGame game = new RacingGame(carNames, rounds);
        game.play();
    }

    private static List<String> getCarNames(final Input input, final Output output) {
        output.printOutput(ENTER_CAR_NAMES);
        return input.getCarNames();
    }

    private static int getRounds(final Input input, final Output output) {
        output.printOutput(ENTER_ROUNDS);
        return input.getRounds();
    }
}
