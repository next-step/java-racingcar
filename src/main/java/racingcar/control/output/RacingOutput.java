package racingcar.control.output;

import racingcar.model.Car;
import racingcar.model.Racing;
import racingcar.view.FirstResultView;
import racingcar.view.ResultView;
import racingcar.view.View;

import java.util.List;

public class RacingOutput extends ConsoleOutput {
    private final Racing racing;

    public RacingOutput(Racing racing) {
        this.racing = racing;
    }

    @Override
    public void print() {
        view().render();
    }

    private View view() {
        int currentRound = this.racing.currentRound();
        List<Car> cars = this.racing.cars();

        return currentRound == 1 ?
                new FirstResultView(cars) :
                new ResultView(cars);
    }
}
