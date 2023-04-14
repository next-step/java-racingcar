package carracing;

import java.util.List;
import java.util.Random;

public class ParticipatedCars {
    List<Car> participatedCars;


    public ParticipatedCars(List<Car> carList) {
        this.participatedCars = carList;
    }

    public void race() {
        for (Car participatedCar : participatedCars) {
            participatedCar.assignMovementCondition(new Random().nextInt(10));
            participatedCar.move();
            InputView.input(participatedCar.distanceToDash());
            OutputView.print();
        }

        OutputView.printNewLine();

    }

    public int count() {
        return this.participatedCars.size();
    }
}
