package racing;

import racing.module.CarGame;
import racing.module.RandomNumberGenerator;
import racing.view.InputView;
import racing.view.OutputView;

public class Main {
    public static void main(String[] args) {
        int carCnt = InputView.inputCar();
        int trial = InputView.inputTrial();

        CarGame carGame = new CarGame(carCnt);
        OutputView.startPrint();

        for (int i = 0; i < trial; i++) {
            carGame.play(new RandomNumberGenerator(), 0);
            OutputView.printCarsPosition(carGame.getCarList());
            System.out.print("\n");
        }
    }
}
