package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameController {

    public void gameStart() {
        InputView inputView = new InputView();
        List<Car> carList = Stream.of(inputView.askCarsName()).map(CarName::new).map(Car::new).collect(Collectors.toList());
        int tryCount = inputView.askTryCount();
        Cars cars = new Cars(carList);

        System.out.println(ResultView.RESULT);

        ResultView resultView = new ResultView();
        while (tryCount > 0) {
            resultView.printLine(cars.carMove());
            System.out.println();
            tryCount --;
        }
        resultView.printWinner(cars);
    }

}
