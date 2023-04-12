package java_racingcar;

public class Car {
    private String distance;

    public Car() {
        this.distance = "";
    }

    public void race(int raceNumber) {
        if (raceNumber < 1 || raceNumber > 9) {
            throw new RuntimeException("1이상 9이하의 값만 가능합니다.");
        }
        if (raceNumber >= 4) {
            moveForward();
        }
    }

    private void moveForward() {
        distance += "-";
    }

    public boolean isMoved() {
        System.out.println(distance);
        return distance != null && !distance.contains("null") && !distance.isEmpty();
    }
}
