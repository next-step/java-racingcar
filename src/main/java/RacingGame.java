import racingcar.controller.PlayGround;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.CarFactoryImpl;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingGame {
    public static void main(String[] args){
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        String[] names = inputView.returnNames();

        CarFactory carFactory = new CarFactoryImpl();
        List<Car> cars = carFactory.makeCars(names);

        int loopCount = inputView.getTryNo();

        PlayGround.play(loopCount,cars);
        resultView.printWinner(cars);
   }

}