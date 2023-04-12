package step3;


public class RacingGame {

    Cars cars;

    public RacingGame() {
        cars = new Cars();
    }

    public void initCars(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
    }

    public void move(int numberOfTry) {
        for (int i = 0; i < numberOfTry; i++) {
            cars.move();
        }
    }

    public Cars getCars() {
        return cars;
    }
}
