package racingCar;

public class CarName {

    private static final int NAME_LENGTH_LIMIT = 5;

    private final String name;

    public CarName(String name) {
        validName(name);
        this.name = name;
    }

    public String findName() {
        return this.name;
    }

    private void validName(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다");
        }
    }
}
