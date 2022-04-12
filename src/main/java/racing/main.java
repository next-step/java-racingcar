package racing;

import racing.module.Car;
import racing.module.CarGame;
import racing.view.InputView;
import racing.view.OutputView;

public class main {
    public static void main(String[] args) {
        int carCnt = InputView.inputCar();
        int trial = InputView.inputTrial();

        CarGame carGame = new CarGame(carCnt);

        System.out.println("\n실행결과");

        for (int i = 0; i < trial; i++) {
            carGame.play();
            OutputView.printCarsPosition(carGame.getCarList());
            System.out.print("\n");
        }
    }
}
