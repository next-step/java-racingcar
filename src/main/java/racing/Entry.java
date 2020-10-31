package racing;

public class Entry {

    private Car[] cars;

    private final int carCount;

    public Entry(int carCount) {
        this.carCount = carCount;
    }

    public void enterCars() {
        cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car();
        }
    }

    public Car[] getCars() {
        return cars;
    }
}
