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

        String nameOfCars = inputView.enterNameOfCars().trim();
        String[] carNames = nameOfCars.split(",");
        int numberOfCars = carNames.length;

        for (String carName : carNames) {
            gameRestartCheck( carNameValidCheck(carName) );
        }

        int numberOfAttempts = inputView.enterNumberOfAttempts();

        List<RacingCar> racingCars = racingCarsInit(numberOfCars);

        resultView.printStart();

        for(int i=0; i < numberOfAttempts; i++) {
            carMove(numberOfCars, racingCars);
            resultView.print(racingCars);
        }
    }

    public boolean carNameValidCheck(String carName) {
        return carName.length() <= 5;
    }

    private void gameRestartCheck(boolean carNameValidResult){
        if(!carNameValidResult) {
            System.out.println("자동차의 이름은 최대 5자 입니다. 게임을 다시 시작합니다.\n");
            start();
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
