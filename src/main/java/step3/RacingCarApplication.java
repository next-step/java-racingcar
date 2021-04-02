package step3;

import java.util.ArrayList;

public class RacingCarApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputDto input = inputView.getInput();
        ResultView resultView = new ResultView();

        ArrayList<RacingCar> carList = new ArrayList<>();

        for (int i = 0; i < input.getNumberOfCar(); i++) {
            carList.add(new RacingCar());
        }

        resultView.printStart();

        for (int i = 0; i < input.getNumberOfTrial(); i++) {
            for (RacingCar racingCar: carList) {
                int moveCount = racingCar.move();
                resultView.printRacingCar(moveCount);
            }
            System.out.println();
        }
    }
}
