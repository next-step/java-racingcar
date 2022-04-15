package racingcar;

public class Car {
    private String track;
    public final String name;

    public Car(String name) {
        this.track = "-";
        this.name = name;
    }

    public String getTrack() {
        return this.track;
    }

    public void move() {
        this.track += "-";
    }

    public void setTrackForTest(String s) {
        this.track = s;
    }
}
