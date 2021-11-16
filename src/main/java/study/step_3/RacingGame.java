package study.step_3;

import study.step_3.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<RacingCar> racingCars = new ArrayList<>();
    private int numberOfCars;
    private int numberOfTrial;

    public RacingGame(Input input) {
        this.numberOfCars = input.getNumberOfCars();
        this.numberOfTrial = input.getNumberOfTrial();

        for (int i = 0; i < this.numberOfCars; i++) {
            this.racingCars.add(new RacingCar());
        }
    }

    public void start() {
        for (int i = 0; i < this.numberOfTrial; i++) {
            for (RacingCar racingCar : this.racingCars) {
                int randomNumber = generateRandomNumber();
                racingCar.move(randomNumber);
            }
            print();
        }
    }

    public boolean isEqualToNumberOfCars(int numberOfCars) {
        return this.racingCars.size() == numberOfCars;
    }

    public boolean isEqualToNumberOfTrial(int numberOfTrial) {
        return this.numberOfTrial == numberOfTrial;
    }

    private void print() {
        OutputView outputView = new OutputView();
        outputView.printDivider();
    }

    private int generateRandomNumber() {
        RandomNumber randomNumber = new RandomNumber();
        return randomNumber.generate();
    }
}
