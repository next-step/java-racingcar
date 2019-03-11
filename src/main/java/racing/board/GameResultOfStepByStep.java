package racing.board;

import racing.model.CarDto;

import java.util.List;
import java.util.stream.Stream;

public class GameResultOfStepByStep {

    private final List<CarDto> result;

    private int maxPosition = 0;

    public GameResultOfStepByStep(List<CarDto> result) {
        this.result = result;

        refreshMaxPosition();
    }

    private void refreshMaxPosition() {
        for (CarDto carDto : result) {
            maxPosition = Math.max(maxPosition, carDto.getPosition());
        }
    }

    public int getMaxPosition() {
        return maxPosition;
    }

    public Stream<CarDto> stream() {
        return result.stream();
    }
}
