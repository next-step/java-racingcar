package step3;

public class CarRacing {

    private Cars cars;
    private CarRacer carRacer;

    public Cars getCars() {
        return this.cars;
    }

    public void createCarsOf(int numOfCars) {
        cars = new Cars(numOfCars);
        carRacer = new CarRacer();
    }

    public void startRace(int numOfTry) {
        for (int i=0; i<numOfTry; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (int i=0; i<cars.getNumOfCars(); i++) {
            cars.findCarBy(i)
                .moveForward(carRacer.stepOnAccelerator());
        }
    }
}
