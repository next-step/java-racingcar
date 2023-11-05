package step3;

public class CarRacing {

    private Car[] cars;
    private CarRacer[] carRacer;

    public Car[] getRacingCars() {
        return this.cars;
    }
    public void createCarsOf(int numOfCars) {
        cars = new Car[numOfCars];
        carRacer = new CarRacer[numOfCars];

        for (int i=0; i<numOfCars; i++) {
            cars[i] = new Car();
            carRacer[i] = new CarRacer();
        }
    }

    public void tryMove(int numOfTry) {
        for (int i=0; i<numOfTry; i++) {
            int power = carRacer[i].stepOnAccelerator();
            cars[i].moveForward(power);
        }
    }
}
