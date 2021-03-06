package study.step3;

public class RacingCarGame {

    public void start() {

        InputView inputView = new InputView();

        int numberOfCars = inputView.enterNumberOfCars();
        int numberOfAttempts = inputView.enterNumberOfAttempts();

        System.out.println("입력 한 자동차 대수는 : " + numberOfCars);
        System.out.println("입력 한 이동할 횟수는 : " + numberOfAttempts);

        RacingCar[] racingCars = new RacingCar[numberOfCars];

        for(int i=0; i < numberOfAttempts; i++) {
            carMove(numberOfCars, racingCars);
        }
    }

    public void carMove(int numberOfCars, RacingCar[] racingCars) {
        for(int i=0; i < numberOfCars; i++){
            racingCars[i].oneStep();
        }
    }

}
