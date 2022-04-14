package racingcar;

public class RacingCar {
    private int movement;
    private int condition;

    public RacingCar() {
        this.movement = 0;
        this.condition = 0;
    }

    public int move(int condition) {
        this.condition = condition;
        this.movement += this.condition > 3 ? 1 : 0;
        return movement;
    }
}
