package carRacing.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {

    public static int THRESHOLD = 4;

    private String name;
    private int score;
    private List<Integer> history;

    public Car(String name, int score, List<Integer> history) {
        this.name = name;
        this.score = score;
        this.history = history;
    }

    public Car(String name, int score) {
        this(name, score, new ArrayList<>());
    }

    public Car(String name) {
        this(name, 0, new ArrayList<>());
    }

    public Car(Car car) {
        this(car.name, car.score, car.history);
    }

    public Car raceOrStay(Car car, int notRandomValue) {
        Car carAfterAction = new Car(car);
        if (notRandomValue >= Car.THRESHOLD) {
            carAfterAction.score += 1;
        }
        carAfterAction.history.add(carAfterAction.score);
        return carAfterAction;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public List<Integer> getHistory() {
        return history;
    }

    public int getHistorySize() {
        return this.history.size();
    }
}
