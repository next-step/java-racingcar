package step3;

import step3.car.Car;
import step3.car.CarFactory;
import step3.view.input.InputDTO;
import step3.view.input.InputView;
import step3.view.result.ResultView;

import java.util.List;

/**
 * 통합 테스트를 위한 클래스.
 *
 */
public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputDTO inputDTO = inputView.receiveInput();
        int tryCount = inputDTO.getTryCount();
        int carCount = inputDTO.getCarCount();

        CarFactory carFactory = new CarFactory();
        List<Car> cars = carFactory.generateCar(carCount);

        RacingGame racingGame = new RacingGame();
        ResultView resultView = new ResultView();
        resultView.printTitle();

        for(int i =0; i < tryCount; i++) {
            racingGame.start(cars);
            resultView.printGameResult(cars);
        }
    }
}
