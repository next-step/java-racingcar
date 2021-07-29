package racing.model;

public class Car {
    private String carName = "";
    private int distance = 0;
    private final static int MAX_WORD_NAME = 5;
    public Car(String name) {
        checkCarName(name);
        this.carName = name;
    }

    public Car(String name, int distance) {
        this.carName = name;
        this.distance = distance;
    }

    public void go() {
        this.distance = ++this.distance;
    }

    public int totalDistance() {
        return this.distance;
    }

    public void checkCarName(String name) {
        if (name.length() > MAX_WORD_NAME) {
            throw new IllegalArgumentException();
        }
    }

    public String getCarInfo() {
        return this.carName;
    }
}
