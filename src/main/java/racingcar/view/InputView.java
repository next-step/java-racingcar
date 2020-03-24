package racingcar.view;

import java.io.InputStream;

public class InputView {
    private final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)를 기준으로 구분)";
    private final String INPUT_TIME_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private Input input;

    public InputView() {
        this(System.in);
    }

    public InputView(InputStream inputStream) {
        input = new Input(inputStream);
    }

    public String inputCarNames() {
        print(INPUT_CAR_NAMES_MESSAGE);
        return input.read();
    }

    public int inputCarCount() {
        print(INPUT_TIME_MESSAGE);
        return Integer.parseInt(input.read());
    }

    public void print(String message) {
        System.out.println(message);
    }
}