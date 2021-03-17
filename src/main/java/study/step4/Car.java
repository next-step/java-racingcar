package study.step4;

public class Car {

    private static final String CAR_NAME_LENGTH_OVER = "자동차의 이름은 5자를 초과할 수 없습니다.";
    private final String carName;
    private int location;

    private Car(final String carName) {
        this.carName = carName;
        this.location = 0;
    }

    public static Car of(final String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_OVER);
        }

        return new Car(carName);
    }

    public void move() {
        location++;
    }

    public void move(int location) {
        this.location += location;
    }

    public String getCarName() {
        return carName;
    }

    public int getLocation() {
        return location;
    }
}
