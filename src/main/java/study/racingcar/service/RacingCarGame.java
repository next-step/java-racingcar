package study.racingcar.service;

import study.racingcar.view.InputView;
import study.racingcar.entity.RacingCar;
import study.racingcar.util.RandomGenerator;
import study.racingcar.view.ResultView;

import java.util.*;
import java.util.stream.Collectors;

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

        List<RacingCar> racingCars = racingCarsInit(carNames, numberOfCars);

        resultView.printStart();

        for(int i=0; i < numberOfAttempts; i++) {
            carMove(numberOfCars, racingCars);
            resultView.print(racingCars);
        }

        resultView.printsWinner(String.join(", ", getWinnerNames(racingCars)));
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

    private List<RacingCar> racingCarsInit(String[] carNames, int numberOfCars) {

        List<RacingCar> racingCars = new ArrayList<>();

        for (int i=0; i < numberOfCars; i++) {
            racingCars.add(new RacingCar(0, carNames[i]));
        }

        return racingCars;
    }

    public void carMove(int numberOfCars, List<RacingCar> racingCars) {

        for(int i=0; i < numberOfCars; i++){
            racingCars.get(i).oneStep(randomGenerator.getRandomNumber());
        }
    }

    public List<String> getWinnerNames(List<RacingCar> racingCars) {

        int maxPosition = getMaxPosition(racingCars);

        return racingCars.stream()
                .filter(racingCar -> racingCar.getPosition() == maxPosition)
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(List<RacingCar> racingCars) {
        return racingCars.stream()
                .max(Comparator.comparingInt(RacingCar::getPosition))
                .get().getPosition();
    }
}
