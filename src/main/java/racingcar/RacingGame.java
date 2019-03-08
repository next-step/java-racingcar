package racingcar;

public class RacingGame {
    private Car[] cars;

    public void start(int numberOfCar, int tryCount) {
        carSetUp(numberOfCar);

        System.out.println("실행 결과\n");

        for (int i = 0; i < tryCount; i++) {
            run();
            showMovedDistanceOfCars(cars);
            System.out.println();
        }
    }

    public Car[] carSetUp(int numberOfCar) {
        this.cars = new Car[numberOfCar];

        for (int i = 0; i < numberOfCar; i++)
            this.cars[i] = new Car();

        return this.cars;
    }

    private void run() {
        for (int i = 0, loop = this.cars.length; i < loop; i++)
            this.cars[i].randomlyGo();
    }

    private void showMovedDistanceOfCars(Car[] cars) {
        for (int i = 0, loop = cars.length; i < loop; i++)
            this.cars[i].showMovedDistance();
    }

    public Car[] getCars() {
        return this.cars;
    }
}
