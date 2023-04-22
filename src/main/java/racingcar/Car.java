package racingcar;

public class Car {
    public final String name;
    private int distance = 0;
    
    public Car(String name) {
        this.name = name;
    }

    public void move(int number) {
        if (number >= 4) {
            distance++;
        }
    }

    public int distanceDriven() {
        return distance;
    }

}
