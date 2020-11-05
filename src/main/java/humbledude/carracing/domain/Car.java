package humbledude.carracing.domain;

public class Car {

    private static final String DEFAULT_CAR_NAME = "car";

    private final String name;
    private int position = 0;

    public Car() {
        this(DEFAULT_CAR_NAME);
    }

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public void accelerate(int fuel) {
        if (fuel >= 4) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름 규칙 : 1 ~ 5글자");
        }
    }
}
