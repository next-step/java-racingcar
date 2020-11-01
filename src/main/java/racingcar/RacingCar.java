package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Random;

public class RacingCar {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int carNum = inputView.getCarNum();
        int tryNum = inputView.getTryNum();

        GameManager gameManager = new GameManager(new Discriminator(new Random()));
        List<Car> cars = gameManager.createCars(carNum);

        for(int i=0;i<tryNum;i++){
            gameManager.move(cars);
            outputView.showResult(cars);
        }
    }
}
