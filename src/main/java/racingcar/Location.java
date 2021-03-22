package racingcar;

public class Location {

    private String location = "";

    public String getLocation() {
        return location;
    }

    public void move() {
        location += "-";
    }

    public void stop() {
        location += "";
    }
}
