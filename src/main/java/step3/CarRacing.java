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

    public void moveCars() {
        for (int i=0; i<cars.getNumOfCars(); i++) {
            cars.findCarBy(i)
                .moveForward(carRacer.stepOnAccelerator());
        }
    }

    public int[] findPositions() {
        int numOfCar = cars.getNumOfCars();

        int[] positions = new int[numOfCar];
        for (int i=0; i<numOfCar; i++) {
            positions[i] = cars.findCarBy(i).getCurrentPosition();
        }

        return positions;
    }
}
