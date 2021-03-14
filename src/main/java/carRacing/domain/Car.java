package carRacing.domain;

public class Car {
    private String name;
    private int score;

    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    public Car(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Car(Car car) {
        this(car.name, car.score);
    }

    public Car raceOrStay(Car car, int notRandomValue) {
        Car carAfterAction = new Car(car);
        if (notRandomValue >= 4) {
            carAfterAction.score += 1;
        }
        return carAfterAction;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        StringBuilder trace = new StringBuilder(this.name + " : ");
        for (int count = 0; count < this.score; count++) {
            trace.append("-");
        }
        return trace.toString();
    }
}
