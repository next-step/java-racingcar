package car;

public class CarName {

    private String name;
    private static final int MAX_LENGTH = 5;

    public CarName(String name) {
        validateLessThanMaxLength(name.length());
        this.name = name;
    }

    private void validateLessThanMaxLength(int length) {
        if (length > MAX_LENGTH) {
            throw new IllegalArgumentException("차 이름은 항상 5를 초과해서는 안됩니다.");
        }
    }

    public String getName() {
        return name;
    }
}
