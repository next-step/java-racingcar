package racing;

import exception.CustomException;
import racing.module.CarGame;
import racing.module.RandomStrategy;
import racing.view.InputView;
import racing.view.OutputView;

public class Main {
    public static void main(String[] args) throws CustomException {
        String carName = InputView.inputCarName();
        int trial = InputView.inputTrial();

        CarGame carGame = new CarGame(carName);
        OutputView.startPrint();

        for (int i = 0; i < trial; i++) {
            carGame.play(new RandomStrategy());
            OutputView.printCarsPosition(carGame.getCarList());
            OutputView.nextline();
        }

        OutputView.printWinner(carGame.getWinner());
    }
}
