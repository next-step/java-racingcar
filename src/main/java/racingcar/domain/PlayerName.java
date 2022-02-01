package racingcar.domain;

public class PlayerName {

    private static final int ZERO_CAR_NAME_LENGTH = 0;
    private static final int LIMITED_CAR_NAME_LENGTH = 5;

    private final String name;

    public PlayerName(String name) {
        validateName(name);
        this.name = name;
    }

    public String get() {
        return name;
    }

    private void validateName(final String name) {
        int nameLength = name.length();
        if (nameLength == ZERO_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("최소한 플레이어 이름은 비어있을 수 없습니다.");
        }

        if (nameLength > LIMITED_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + LIMITED_CAR_NAME_LENGTH + "자를 넘을 수 없습니다.");
        }
    }
}
