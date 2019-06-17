package racingcar.view.input;

public class DefaultInputView implements InputView {

    private static final Integer MAX_NUMBER = 100;
    private static final String MESSAGE_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String MESSAGE_NUMBER_OF_TIMES = "시도할 회수는 몇 회 인가요?";

    private final NumberInputReader numberInputReader;

    public DefaultInputView(NumberInputReader numberInputReader) {
        this.numberInputReader = numberInputReader;
    }

    @Override
    public Integer getNumberOfCars() {
        return checkInput(getInput(MESSAGE_NUMBER_OF_CARS));
    }

    @Override
    public Integer getNumberOfTimes() {
        return checkInput(getInput(MESSAGE_NUMBER_OF_TIMES));
    }

    private Integer getInput(String message) {
        System.out.println(message);
        return numberInputReader.get();
    }

    private Integer checkInput(Integer num) {
        if (num == null || num < 0 || num > MAX_NUMBER) {
            throw new IllegalArgumentException("Invalid input");
        }

        return num;
    }
}
