package racing.model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String name;
    private int score;
    private List<Position> position;
    private CarMovementStrategy carMovementStrategy;

    public Car(String name, CarMovementStrategy carMovementStrategy) {
        this(name, 0, carMovementStrategy);
    }

    private Car(String name, int score, CarMovementStrategy carMovementStrategy) {
        this.name = name;
        this.score = score;
        this.position = new ArrayList<>();
        this.carMovementStrategy = carMovementStrategy;
    }

    public void move() {
        if (carMovementStrategy.movable()) {
            score++;
        }
        position.add(new Position(score));
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public String getPosition(int index) {
        return this.position.get(index).getResult();
    }
}
