package step3;

public class CarRacing {

    private Cars cars;
    private CarRacer[] carRacer;

    public Cars getCars() {
        return this.cars;
    }

    public void createCarsOf(int numOfCars) {
        cars = new Cars(numOfCars);
        carRacer = new CarRacer[numOfCars];

        for (int i=0; i<numOfCars; i++) {
            carRacer[i] = new CarRacer();
        }
    }

    public void tryMove(int numOfTry) {
        for (int i=0; i<numOfTry; i++) {
            int power = carRacer[i].stepOnAccelerator();
            cars.findCarBy(i).moveForward(power);
        }
    }
}
