package racingcar;

import racingcar.strategy.RandomMovableStrategy;

public class Main {
    public static void main(String[] args) {
        String[] carNames = InputView.queryListOfCarNames();
        int numberOfTrials = InputView.queryNumberOfTrials();

        CarRace carRace = new CarRace(carNames, new RandomMovableStrategy());
        for (int i = 0; i < numberOfTrials; i++) {
            carRace.race();
            ResultView.printCars(carRace.getCars());
        }
    }
}
