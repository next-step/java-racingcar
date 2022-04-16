package racingcar;

import java.util.List;

public class RacingCar implements Comparable {
    private final static int MOVE_THRESHOLD = 3;
    private final static int MOVE = 1;
    private final static int STAY = 0;

    private int movement;
    private String name;

    public RacingCar() {
        this.movement = 0;
    }

    public RacingCar(String name) {
        this();
        this.name = name;
    }

    public int move(int condition) {
        this.movement += condition > MOVE_THRESHOLD ? MOVE : STAY;
        return movement;
    }

    public int getMovement() {
        return movement;
    }

    public String getName() {
        return name;
    }

    public List<RacingCar> compareHighScoreCar(RacingCar highestCar, List<RacingCar> winnerCars) {
        if (this.movement == highestCar.getMovement()) {
            winnerCars.add(this);
        }
        return winnerCars;
    }

    @Override
    public int compareTo(Object o) {
        RacingCar another = (RacingCar) o;
        return Integer.compare(this.movement, another.getMovement()) * -1;
    }
}
