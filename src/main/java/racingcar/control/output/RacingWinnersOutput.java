package racingcar.control.output;

import racingcar.model.dto.CarDto;
import racingcar.view.WinnerResultView;

import java.util.List;

public class RacingWinnersOutput implements Printable {
    private final List<CarDto> winners;

    public RacingWinnersOutput(List<CarDto> winners) {
        this.winners = winners;
    }

    @Override
    public void print() {
        new WinnerResultView(winners).render();
    }
}
