package camp.nextstep.edu.racingcar.view.console;

import camp.nextstep.edu.racingcar.view.InputHandler;
import camp.nextstep.edu.racingcar.view.InputView;
import camp.nextstep.edu.racingcar.view.OutputHandler;
import camp.nextstep.edu.racingcar.view.dto.GameRequest;

public class ConsoleInputView implements InputView {

    private static final String MESSAGE_FOR_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String MESSAGE_FOR_NUMBER_OF_ROUNDS = "시도할 회수는 몇 회 인가요?";

    private final InputHandler<Integer> consoleIntegerInputHandler;
    private final OutputHandler<String> consoleStringOutputHandler;

    public ConsoleInputView(InputHandler<Integer> consoleIntegerInputHandler,
                            OutputHandler<String> consoleStringOutputHandler) {
        this.consoleIntegerInputHandler = consoleIntegerInputHandler;
        this.consoleStringOutputHandler = consoleStringOutputHandler;
    }

    @Override
    public GameRequest printAndGetInput() {
        final int numberOfCars = this.getNumberOfCars();
        final int numberOfRounds = this.getNumberOfRounds();
        return GameRequest.of(numberOfCars, numberOfRounds);
    }

    private int getNumberOfCars() {
        consoleStringOutputHandler.handle(MESSAGE_FOR_NUMBER_OF_CARS);
        return consoleIntegerInputHandler.getInput();
    }

    private int getNumberOfRounds() {
        consoleStringOutputHandler.handle(MESSAGE_FOR_NUMBER_OF_ROUNDS);
        return consoleIntegerInputHandler.getInput();
    }
}
