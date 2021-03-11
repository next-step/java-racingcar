package step3.study.domain;

public class Car {
    private String distance = "";
    private static final int MOVE_CONDITION = 4;

    public String move(int randomNumber) {
        if (MOVE_CONDITION <= randomNumber) {
            this.distance += "-";
        }
        return this.distance;
    }

    public String getDistance() {
        return this.distance;
    }
}
