package step3;

import java.util.Random;

public class Racing {

    private int carNumber;
    private int repeatNumber;

    public Racing(int carNumber, int repeatNumber) {
        this.carNumber = carNumber;
        this.repeatNumber = repeatNumber;
    }

    public void racing() {
        Car[] cars = makeCar(this.carNumber);
        for (int i = 0; i < this.repeatNumber; i++) {
            play(cars);
            ResultView resultView = new ResultView();
            resultView.result(cars);
        }
    }

    public Car[] makeCar(int carNumber) {
        Car[] cars = new Car[carNumber];
        for (int i = 0; i < carNumber; i++) {
            cars[i] = new Car(1);
        }
        return cars;
    }

    public void play(Car[] cars) {
        for (Car car : cars) {
            movement(car);
        }
    }

    public void movement(Car car) {
        while (random() >= 4) {
            car.point++;
        }
    }

    public int random() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
