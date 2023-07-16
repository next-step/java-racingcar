package study.step3.domain;

public class Cars {
    private final Car[] cars;

    public Cars(Car[] cars) {
        this.cars = cars;
    }

    public Car[] getCars() {
        return cars;
    }

    public void race() {
        for (Car car : cars) {
            car.move();
        }
    }
}
