package racingcar.domain;

public class Participant {
    private static final int MAX_NAME_LENGTH = 5;
    public static final String MESSAGE_INPUT_PERSONAL_NAME = "개인 참가자 이름을 입력하세요.";
    public static final String MESSAGE_MAX_NAME_LENGTH = new StringBuilder("개인 참가자 이름의 길이는 ")
            .append(MAX_NAME_LENGTH)
            .append("글자를 초과할 수 없습니다.")
            .toString();

    private String name;

    public Participant(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private static void validate(String name) {
        if (null == name || name.length() == 0 || name.trim().length() == 0) {
            throw new IllegalArgumentException(MESSAGE_INPUT_PERSONAL_NAME);
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MESSAGE_MAX_NAME_LENGTH);
        }
    }
}
