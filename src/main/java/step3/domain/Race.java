package step3.domain;

import java.util.HashSet;
import java.util.Set;

public class Race {

    private static final int INITIAL_STEP = 0;

    private Set<Car> cars;
    private int numOfCars;
    private int rounds;

    public void setUpRace(int numOfCars, int rounds) {
        this.numOfCars = numOfCars;
        this.rounds = rounds;
        this.setCars();
    }

    public void runOneRound() {
        CarMove carMove = new CarMove();

        for (Car car : this.cars) {
            car.move(carMove.checkMovable());
        }
    }

    private void setCars() {
        cars = new HashSet<>(this.numOfCars);

        for (int i = 0; i < this.numOfCars; i++) {
            Car car = new Car(INITIAL_STEP);
            cars.add(car);
        }
    }

    public Set<Car> getCars() {
        return this.cars;
    }

    public int getNumOfRounds() {
        return this.rounds;
    }

}
