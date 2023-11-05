package racing;

public class Car {

    private int number;
    private int distance;

    public Car(int number) {
        this.number = number;
        this.distance = 0;
    }

    public int carNumber() {
        return number;
    }

    public int carDistance() {
        return distance;
    }

    public void move(int random) {
        if (random > 3) {
            distance += 1;
        }
    }
}
