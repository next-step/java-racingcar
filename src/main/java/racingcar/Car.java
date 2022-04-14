package racingcar;

public class Car {
    private String track = "-";

    public String getTrack() {
        return this.track;
    };

    public void move() {
        this.track += "-";
    }
}
