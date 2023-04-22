package java_racingcar;

public class Car {
    private String distance;

    public Car() {
        this.distance = "";
    }

    void race(int raceNumber) {
        if (raceNumber < 0 || raceNumber > 9) {
            throw new RuntimeException("0이상 9이하의 값만 가능합니다.");
        }
        if (raceNumber >= 4) {
            moveForward();
        }
    }

    private void moveForward() {
        distance += "-";
    }

    String raceResult() {
        return distance;
    }
}
