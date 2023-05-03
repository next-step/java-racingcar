package racingcar.domain;

public class Name {
    public static final int NAME_MAXIMUM_BOUND = 5;
    private final String name;

    public Name(String name) {
        validateCarName(name);
        this.name = name;
    }

    public String getCarName() {
        return name;
    }

    private void validateCarName(String carName) {
        if (carName.length() > NAME_MAXIMUM_BOUND) {
            throw new RuntimeException("5자 이상의 이름은 입력할 수 없습니다.");
        }
    }
}
