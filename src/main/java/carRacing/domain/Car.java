package carRacing.domain;

public class Car {

    public static int THRESHOLD = 4;

    private String name;
    private int score;

    public Car(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Car(String name) {
        this(name, 0);
    }

    public Car(Car car) {
        this(car.name, car.score);
    }

    public Car raceOrStay(Car car, int notRandomValue) {
        Car carAfterAction = new Car(car);
        if (notRandomValue >= Car.THRESHOLD) {
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

}
