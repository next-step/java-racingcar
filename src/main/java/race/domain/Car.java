package race.domain;

public class Car {

    private String name;
    private int movingDistance;
    private StringBuilder tracing;


    public Car() {
    }

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

    public String printDistance() {
        return String.valueOf(tracing);
    }

    public int getMovingDistance() {
        return this.movingDistance;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (isOverThanFive(name)) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }

        if (isBlank(name)) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }

    private boolean isOverThanFive(String name) {
        return name.length() > 5;
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private boolean isOverThanThree(int input) {
        return input > 3;
    }
}
