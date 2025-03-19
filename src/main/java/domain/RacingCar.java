package domain;

public class RacingCar {
    private Integer position;

    public RacingCar() {
        this.position = 0;
    }

    public Integer whereIsCar() {
        return this.position;
    }

    public void tryToGo(Integer steps) {
        this.position += steps;
    }
}
