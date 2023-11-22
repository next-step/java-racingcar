package racingCar.domain;


public class CarName {
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    private CarName(String name) {
        this.name = name;
    }

    public static CarName from(String name) {
        validateLength(name);
        return new CarName(name);
    }

    private static void validateLength(String name) {
        if (!isValidLength(name)) {
            throw new IllegalArgumentException(String.format("이름은 %d자를 넘을 수 없습니다.", MAX_NAME_LENGTH));
        }
    }

    private static boolean isValidLength(String name) {
        return name.length() <= MAX_NAME_LENGTH;
    }
  
    public String getName() {
        return name;
    }
}
