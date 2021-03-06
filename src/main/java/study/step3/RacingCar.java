package study.step3;

public class RacingCar {

    public void start() {

        InputView inputView = new InputView();

        int numberOfCars = inputView.enterNumberOfCars();
        int numberOfAttempts = inputView.enterNumberOfAttempts();

        System.out.println("입력 한 자동차 대수는 : " + numberOfCars);
        System.out.println("입력 한 이동할 횟수는 : " + numberOfAttempts);
    }
}
