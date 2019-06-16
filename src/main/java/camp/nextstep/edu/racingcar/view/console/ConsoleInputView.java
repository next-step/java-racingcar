package camp.nextstep.edu.racingcar.view.console;

import camp.nextstep.edu.racingcar.domain.CarNames;
import camp.nextstep.edu.racingcar.view.InputHandler;
import camp.nextstep.edu.racingcar.view.InputView;
import camp.nextstep.edu.racingcar.view.OutputHandler;
import camp.nextstep.edu.racingcar.view.dto.GameRequest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsoleInputView implements InputView {

    private static final String MESSAGE_FOR_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MESSAGE_FOR_NUMBER_OF_ROUNDS = "시도할 회수는 몇 회 인가요?";
    private static final String DELIMITER_CAR_NAME = ",";

    private final InputHandler<Integer> consoleIntegerInputHandler;
    private final InputHandler<String> consoleStringInputHandler;
    private final OutputHandler<String> consoleStringOutputHandler;

    public ConsoleInputView(InputHandler<Integer> consoleIntegerInputHandler,
                            InputHandler<String> consoleStringInputHandler,
                            OutputHandler<String> consoleStringOutputHandler) {
        this.consoleIntegerInputHandler = consoleIntegerInputHandler;
        this.consoleStringInputHandler = consoleStringInputHandler;
        this.consoleStringOutputHandler = consoleStringOutputHandler;
    }

    @Override
    public GameRequest printAndGetInput() {
        final CarNames carNames = this.getCarNames();
        final int numberOfRounds = this.getNumberOfRounds();
        return GameRequest.of(carNames, numberOfRounds);
    }

    private CarNames getCarNames() {
        consoleStringOutputHandler.handle(MESSAGE_FOR_CAR_NAMES);
        final String carNameString = consoleStringInputHandler.getInput();
        return convertStringToCarNames(carNameString);
    }

    private int getNumberOfRounds() {
        consoleStringOutputHandler.handle(MESSAGE_FOR_NUMBER_OF_ROUNDS);
        return consoleIntegerInputHandler.getInput();
    }

    private CarNames convertStringToCarNames(String carNameString) {
        final String[] splitCarNames = carNameString.split(DELIMITER_CAR_NAME);
        final List<String> carNameList = Stream.of(splitCarNames)
                .collect(Collectors.toList());
        return CarNames.from(carNameList);
    }
}
