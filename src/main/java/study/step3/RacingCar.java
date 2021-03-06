package study.step3;

public class RacingCar {

    public void start() {

        InputView inputView = new InputView();
        int numberOfCars = inputView.enterNumberOfCars();
        System.out.println("입력 한 자동차 대수는 : " + numberOfCars);

    }



}
