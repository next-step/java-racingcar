package racingcar.domain.car;

public class Car {

    private static final String NAME_LENGTH_ERROR_MESSAGE = "자동차 이름이 5자를 초과합니다.";
    private final String name;
    public int position;
    private Car(String name) {
        validateCarName(name);
        this.name = name;
        this.position = 0;
    }

    private Car(String name, int position) {
        validateCarName(name);
        this.name = name;
        this.position = position;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public static Car of(String name, int position) {
        return new Car(name, position);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void go() {
        this.position += 1;
    }

    private static void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public boolean comparePosition(Car o) {
        return position == o.position;
    }
}
