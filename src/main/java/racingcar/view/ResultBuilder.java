package racingcar.view;

import racingcar.domain.Position;
import racingcar.domain.input.CarName;

public class ResultBuilder {

    private static final String DIVISION = " : ";
    private static final String DISTANCE_ONE_STEP = "-";
    private final Position position;
    private final CarName carName;

    public ResultBuilder(Position position, CarName carName) {
        this.position = position;
        this.carName = carName;
    }

    public String build() {
        StringBuilder bs = new StringBuilder();
        bs.append(carName);
        bs.append(DIVISION);
        int moveDistance = 0;
        while (!position.isSameMoveDistance(moveDistance)) {
            bs.append(DISTANCE_ONE_STEP);
            moveDistance++;
        }
        return bs.toString();
    }
}
