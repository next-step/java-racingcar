package step4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {

    private final int numberOfRace;
    private final Random random = new Random();

    private List<Car> cars = new ArrayList<>();

    public RacingCar(final List<String> carNameList, final int numberOfRace) {
        for (String carName : carNameList) {
            cars.add(new Car(carName, 0));
        }

        this.numberOfRace = numberOfRace;
    }

    public int getNumberOfCar() {
        return this.cars.size();
    }

    public String getNameOfCar(int index) {
        return this.cars.get(index).getName();
    }

    public int getNumberOfRace() {
        return this.numberOfRace;
    }

    public int getCarPosition(int index) {
        return this.cars.get(index).getPosition();
    }

    public int generateRandomNumber() {
        return random.nextInt(10);
    }

    public void doRacing() {
        for (int i = 0; i < getNumberOfCar(); i++) {
            moveCar(generateRandomNumber(), i);
        }
    }

    public void moveCar(int number, int carNumber) {
        if (number >= 4)
            this.cars.get(carNumber).move();

    }

    public List<String> getWinner() {
        int maxPosition = 0;
        List<String> winner = new ArrayList<>();

        for (Car car : this.cars) {
            maxPosition = car.compareAndGetMax(maxPosition);
        }

        for (Car car : this.cars) {
            if (car.compareAndGetMax(maxPosition) == maxPosition)
                winner.add(car.getName());
        }

        return winner;
    }

    public Integer compareNumberOfRace(int compareNumber) {
        if (this.numberOfRace > compareNumber)
            return 1;
        if (this.numberOfRace == compareNumber)
            return 0;
        return -1;
    }


}
