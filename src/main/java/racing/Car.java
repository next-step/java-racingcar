package racing;

public class Car {
    private Long position;

    Car() {
        this.position = 0L;
    }

    public static boolean isValidNameLength(String carName) {
        return StringValidator.isLessThanEqualLen(carName, 5);
    }

    public void forward(boolean condition) {
        if (condition) this.position++;
    }

    public Long getPosition() {
        return position;
    }
}
