package racingcar;

public class RacingCar {
    private int distance;
    private RacingCarMoveBehavior racingCarMoveBehavior;

    public RacingCar(RacingCarMoveBehavior racingCarMoveBehavior) {
        this.distance = 0;
        this.racingCarMoveBehavior = racingCarMoveBehavior;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        distance = this.racingCarMoveBehavior.action(distance);
    }

    public void display() {
        for(int i = 0; i < distance; i++) {
            System.out.print('-');
        }
        System.out.println();
    }
}
