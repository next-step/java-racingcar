package racingcar.domain;

public class CarStatus {

    private final String name;

    private final int grade;

    public CarStatus(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String toString() {
        return name + " : " + "-".repeat(Math.max(0, grade));
    }
}
