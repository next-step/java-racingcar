package racingcar;

import racingcar.view.ConsoleView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final ConsoleView view;
    private final RandomGenerator randomGenerator;

    public RacingGame(ConsoleView view, RandomGenerator randomGenerator) {
        this.view = view;
        this.randomGenerator = randomGenerator;
    }

    public void run() {
        getInputsFromUser();

        List<Car> cars = makeCarsOf(view.numbOfCar());

        runWithCarsNTimes(view.numbOfTrial(), cars);
    }

    private void getInputsFromUser() {
        view.questionAboutNumberOfTrial();
        view.questionAboutNumberOfCars();
    }


    private List<Car> makeCarsOf(int numb) {
        List<Car> cars = new ArrayList<>();

        for(int i = 0; i < numb; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    private void runWithCarsNTimes(int trials, List<Car> cars) {
        for (int i = 0; i < trials; i++) {
            moveAndPrint(cars);
        }
    }

    private void moveAndPrint(List<Car> cars) {

        for (Car car: cars) {
            int rand = randomGenerator.generate();
            car.moveDependingOn(rand);

            view.printCarLocation(car.location());
        }
    }
}
