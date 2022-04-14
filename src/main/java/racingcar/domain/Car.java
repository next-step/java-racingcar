package racingcar.domain;

public class Car {
    private String currentPosition;

    public Car() {
        currentPosition = "";
    }

    public String getCurrentPosition() {
        return this.currentPosition;
    }

    public String go() {
        return this.currentPosition += "-";
    }

    public String stop() {
        return this.currentPosition = this.currentPosition;
    }
}
