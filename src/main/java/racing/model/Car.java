package racing.model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private int score;
    private List<Position> position;
    private CarMovementStrategy carMovementStrategy;

    public Car(CarMovementStrategy carMovementStrategy) {
        this(0, carMovementStrategy);
    }

    private Car(int position, CarMovementStrategy carMovementStrategy) {
        this.score = position;
        this.position = new ArrayList<>();
        this.carMovementStrategy = carMovementStrategy;
    }

    public void move() {
        if (carMovementStrategy.movable()) {
            score++;
        }
        position.add(new Position(score));
    }

    public int getScore() {
        return this.score;
    }

    public String getPosition(int index) {
        return this.position.get(index).getResult();
    }
}
