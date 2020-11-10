package racingcar;

public class RacingCar {
    private int distance;
    private String name;
    private RacingCarMoveBehavior racingCarMoveBehavior;

    public RacingCar(String name, RacingCarMoveBehavior racingCarMoveBehavior) {
        this.distance = 0;
        this.name = name;
        this.racingCarMoveBehavior = racingCarMoveBehavior;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void move() {
        distance = this.racingCarMoveBehavior.action(distance);
    }

    public void display() {
        if (distance != 0) {
            System.out.print(name + " : ");
        }
        for(int i = 0; i < distance; i++) {
            System.out.print('-');
        }
        System.out.println();
    }
}
