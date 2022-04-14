package racingcar;

public class RacingCar {
    private int movement;

    public RacingCar() {
        this.movement = 0;
    }

    public int move(int condition) {
        this.movement += condition > 3 ? 1 : 0;
        return movement;
    }
}
