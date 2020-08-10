package carracing.domain;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    private int carCount = 0;
    private int tryCount = 0;
    private ArrayList<Car> cars = null;

    public Game(int carCount, int tryCount){
        this.carCount = carCount;
        this.tryCount = tryCount;

        inputValid();

        this.cars = this.generateCars(carCount);

    }

    public void start() {
        for(int i = 0; i < this.tryCount; i++) {
            this.play();
        }
    }

    private ArrayList<Car> generateCars(int carCount) {
        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 1; i <= carCount; i++) {
            Car car = new Car(i);
            cars.add(car);
        }
        return cars;
    }

    private void inputValid() {
        if( this.carCount == 0 || this.tryCount == 0) throw new IllegalArgumentException("입력값을 확인해주세요.");
    }

    private int crateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    private void play() {
        for(Car car : cars) {
            car.setPosition(this.crateRandomNumber());
            car.getGraphics();
        }
        System.out.println("");
    }
}
