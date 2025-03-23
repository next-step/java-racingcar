package step5.domain;

import step5.util.NumberRandomUtil;
import step5.view.InputView;
import step5.view.ResultView;

import java.util.List;

public class RacingGame {
    public void race() {
        List<String> names = InputView.nameOfCars();
        Cars cars = Cars.from(names);

        int times = InputView.times();

        ResultView.output();
        for (int i = 0; i < times; i++) {
            cars.move(NumberRandomUtil.generateList(names.size()));
            ResultView.position(cars);
        }
        ResultView.result(cars.winners());
    }
}


