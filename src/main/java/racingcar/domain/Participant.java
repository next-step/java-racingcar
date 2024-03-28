package racingcar.domain;

public class Participant {
    private static final int MAX_NAME_LENGTH = 5;

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
            throw new IllegalArgumentException("개인 참가자 이름을 입력하세요.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("개인 참가자 이름의 길이는 " + MAX_NAME_LENGTH + "글자를 초과할 수 없습니다.");
        }
    }
}
