package racingcar.view;

import java.io.InputStream;

public class InputView {
    private static final String INPUT_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_TIME_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private Input input;

    public InputView() {
        this(System.in);
    }

    public InputView(InputStream inputStream) {
        input = new Input(inputStream);
    }

    public int insertCarCount() {
        System.out.println(INPUT_CAR_COUNT_MESSAGE);
        return Integer.parseInt(input.read());
    }

    public int insertTime() {
        System.out.println(INPUT_TIME_MESSAGE);
        return Integer.parseInt(input.read());
    }
}
