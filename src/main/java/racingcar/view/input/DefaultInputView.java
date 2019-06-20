package racingcar.view.input;

import java.util.List;

public class DefaultInputView implements InputView {

    private static final String MESSAGE_LIST_OF_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MESSAGE_NUMBER_OF_TIMES = "시도할 회수는 몇 회 인가요?";

    private final CommandLineReader commandLineReader;

    public DefaultInputView(CommandLineReader commandLineReader) {
        this.commandLineReader = commandLineReader;
    }

    @Override
    public List<String> getCarNames() {
        System.out.println(MESSAGE_LIST_OF_CARS);
        return commandLineReader.getCsv();
    }

    @Override
    public Integer getNumberOfTimes() {
        System.out.println(MESSAGE_NUMBER_OF_TIMES);
        return commandLineReader.getNumber();
    }
}
