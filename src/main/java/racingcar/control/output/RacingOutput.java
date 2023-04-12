package racingcar.control.output;

import racingcar.model.dto.CarDto;
import racingcar.model.dto.RacingDto;
import racingcar.view.FirstResultView;
import racingcar.view.ResultView;
import racingcar.view.View;

import java.util.List;

public class RacingOutput implements Printable {
    private final RacingDto racing;

    public RacingOutput(RacingDto racing) {
        this.racing = racing;
    }

    @Override
    public void print() {
        view().render();
    }

    private View view() {
        int currentRound = this.racing.currentRound();
        List<CarDto> cars = this.racing.cars();

        return currentRound == 1 ?
                new FirstResultView(cars) :
                new ResultView(cars);
    }
}
