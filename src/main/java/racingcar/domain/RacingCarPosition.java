package racingcar.domain;

import racingcar.utils.Const;

import java.util.stream.IntStream;

public class RacingCarPosition {
    private final String PROGRESS_POSITION = "-";
    private int position;
    private String carName;

    public RacingCarPosition(RacingCar racingCar) {
        this.carName = racingCar.toString();
        this.position = racingCar.getPosition();
    }

    @Override
    public String toString() {
        StringBuilder positionProgressBar = new StringBuilder();
        IntStream.range(Const.INITIAL_NUM, position)
                .forEach(position -> positionProgressBar.append(PROGRESS_POSITION));
        return String.format("%s : %s", this.carName, positionProgressBar.toString());
    }
}
