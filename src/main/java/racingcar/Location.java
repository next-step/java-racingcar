package racingcar;

public class Position {

    private String location = "";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location += location;
    }

    public void move() {
        location = "-";
    }

    public void stop() {
        location = "";
    }
}
