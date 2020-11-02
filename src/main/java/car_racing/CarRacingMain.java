package car_racing;

import java.util.Random;

public class CarRacingMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.execute(
                new CarRacingViewController(
                        new ResultView(),
                        new CarRacingManager(new Random())));
    }
}
