package racingcar.domain;

public class CarLocation {
    private int location;

    public CarLocation() {
        this.location = 0;
    }

    public void increase() {
        location++;
    }

    public boolean isMaxLocation(int max) {
        return this.location == max;
    }

    public int checkMaxLocation(int carLocation) {
        return Math.max(this.location, carLocation);
    }

    public String locationMark() {
        String mark = "-";
        return mark.repeat(this.location);
    }
}
