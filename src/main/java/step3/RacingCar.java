package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {

    private final int numberOfCar;
    private final int numberOfRace;
    private final Random random = new Random();

    private List<Car> cars = new ArrayList<>();

    public RacingCar(final int numberOfCar, final int numberOfRace) {
        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car(0));
        }

        this.numberOfCar = numberOfCar;
        this.numberOfRace = numberOfRace;
    }

    public int getNumberOfCar() {
        return this.numberOfCar;
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
        for (int i = 0; i < numberOfCar; i++) {
            moveCar(generateRandomNumber(), i);
        }
    }

    public void moveCar(int number, int carNumber) {
        if (number >= 4)
            this.cars.get(carNumber).move();
    }

    public void startRacing(OutputView outputView) {
        for (int i = 0; i < numberOfRace; i++) {
            doRacing();
            RacingCarResultView.printRacingCarStatus(outputView, this);
        }
    }

}
