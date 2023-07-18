package study.racinggame;

import study.racinggame.domain.Cars;
import study.racinggame.util.NameUtil;
import study.racinggame.view.InputView;
import study.racinggame.view.ResultView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        final List<String> carNames = NameUtil.convertToList(InputView.carNames());
        final int repeatCount = InputView.repeatCount();

        final Cars cars = new Cars(carNames, repeatCount);

        while (!cars.isEndGame()) {
            cars.race();
            ResultView.printOutPositions(cars);
        }
    }
}
