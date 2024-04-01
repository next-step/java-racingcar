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
        if (this.location <= carLocation) {
            return carLocation;
        }
        return this.location;
    }

    public String locationMark() {
        String mark = "-";
        return mark.repeat(this.location);
    }
}
