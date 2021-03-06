package study.step3;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    static final RandomGenerator randomGenerator = new RandomGenerator();

    public void start() {

        InputView inputView = new InputView();

        int numberOfCars = inputView.enterNumberOfCars();
        int numberOfAttempts = inputView.enterNumberOfAttempts();

        System.out.println("입력 한 자동차 대수는 : " + numberOfCars);
        System.out.println("입력 한 이동할 횟수는 : " + numberOfAttempts);

        List<RacingCar> racingCars = racingCarsInit(numberOfCars);

        for(int i=0; i < numberOfAttempts; i++) {
            carMove(numberOfCars, racingCars);
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
