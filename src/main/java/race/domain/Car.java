package race.domain;

public class Car {

    private final String name;
    private int movingDistance;
    private StringBuilder tracing;
    private static final int MIN_NAME_LENGTH = 5;
    private static final int BOUND_NUMBER = 3;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.tracing = new StringBuilder().append(name).append(" : ");
    }

    public Car(String name, int movingDistance) {
        this.name = name;
        this.movingDistance = movingDistance;
    }

    public void move(int input) {
        if (isOverThanThree(input)) {
            this.movingDistance++;
            this.tracing.append("-");
        }
    }

    public String getTracing() {
        return String.valueOf(tracing);
    }

    public int getMovingDistance() {
        return this.movingDistance;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }

        if (isOverThanFive(name)) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }

    private boolean isOverThanFive(String name) {
        return name.length() > MIN_NAME_LENGTH;
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private boolean isOverThanThree(int input) {
        return input > BOUND_NUMBER;
    }
}
