package racingcar;

import java.util.Arrays;

public class InputView {
    private final Screen screen = new Screen();
    private final Console console = new Console();

    public String[] participantApplication() {
        screen.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = splitName(console.inputString());
        validateNames(names);
        return names;
    }

    public int playCount() {
        screen.print("시도할 회수는 몇 회 인가요?");
        return console.inputInt();
    }


    private String[] splitName(String name) {
        final String DELIMITER_COMMA = ",";
        return name.split(DELIMITER_COMMA);
    }

    private void validateNames(String[] names) {
        Arrays.stream(names).forEach(this::validateNameBlank);
        Arrays.stream(names).forEach(this::validateNameLength);
    }


    private void validateNameBlank(String name) {
        if (name.isBlank()) {
            throw new RuntimeException("이름은 공백일 수 없습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (isLengthGrateThen(name)) {
            throw new RuntimeException("이름은 5자를 초과할 수 없습니다.");
        }
    }

    private boolean isLengthGrateThen(String name) {
        final int MAX_LENGTH = 5;
        return name.length() > MAX_LENGTH;
    }

}
