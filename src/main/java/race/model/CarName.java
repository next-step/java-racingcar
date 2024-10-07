package race.model;

public class CarName {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
        }

        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public void printName() {
        System.out.print(name);
    }

    public void printNameWithComma(boolean addComma) {
        printName();
        if (addComma) {
            System.out.print(", ");
        }
    }
}
