package racing;

import racing.module.CarGame;
import racing.module.Input;

public class main {
    public static void main(String[] args) {
        int carCnt = Input.inputCar();
        int trial = Input.inputTrial();

        CarGame carGame = new CarGame(carCnt);

        System.out.println("\n실행결과");

        for (int i = 0; i < trial; i++) {
            carGame.playAndPrint();
        }
    }
}
