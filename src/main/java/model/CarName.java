package model;

public class CarName {
    private String name;
    private static final int MAX_NAME_LENGTH = 5;

    public CarName(String name) {
        if (isNameLengthValid(name)) {
            throw new RuntimeException(String.format("이름은 %d글자를 넘을 수 없습니다.", MAX_NAME_LENGTH));
        }

        this.name = name;
    }

    private static boolean isNameLengthValid(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    @Override
    public String toString() {
        return name;
    }
}
