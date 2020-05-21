package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        Cars cars = new Cars();

        inputView.scanner();
        cars.makeCars(inputView.getCarCount());

        for (int time = 0; time < inputView.getInputTime(); time++) {
            cars.playGame();
            System.out.println("");
        }
    }



}
