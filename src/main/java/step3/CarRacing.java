package step3;

public class CarRacing {

    private Car[] cars;

    public Car[] getRacingCars() {
        return this.cars;
    }
    public void createCarsOf(int numOfCars) {
        cars = new Car[numOfCars];

        for (int i=0; i<numOfCars; i++) {
            cars[i] = new Car();
        }
    }
}
