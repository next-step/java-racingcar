package racingcar.view;

import java.io.InputStream;

public class InputView {
    public static final String INPUT_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    public static final String INPUT_TIME_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private Input input;

    public InputView() {
        this(System.in);
    }

    public InputView(InputStream inputStream) {
        input = new Input(inputStream);
    }

    public int view(String message) {
        print(message);
        return Integer.parseInt(input.read());
    }

    public void print(String message) {
        System.out.println(message);
    }
}
