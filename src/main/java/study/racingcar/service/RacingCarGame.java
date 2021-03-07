package study.racingcar.service;

import study.racingcar.view.InputView;
import study.racingcar.entity.RacingCar;
import study.racingcar.util.RandomGenerator;
import study.racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private static final RandomGenerator randomGenerator = new RandomGenerator();

    public void start() {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int numberOfCars = inputView.enterNumberOfCars();
        int numberOfAttempts = inputView.enterNumberOfAttempts();

        List<RacingCar> racingCars = racingCarsInit(numberOfCars);

        resultView.printStart();

        for(int i=0; i < numberOfAttempts; i++) {
            carMove(numberOfCars, racingCars);
            resultView.print(racingCars);
        }
    }

    private List<RacingCar> racingCarsInit(int numberOfCars) {

        List<RacingCar> racingCars = new ArrayList<>();

        for (int i=0; i < numberOfCars; i++) {
            racingCars.add(new RacingCar());
        }

        return racingCars;
    }

    public void carMove(int numberOfCars, List<RacingCar> racingCars) {

        for(int i=0; i < numberOfCars; i++){
            racingCars.get(i).oneStep(randomGenerator.getRandomNumber());
        }
    }

}
