package racingcar.domain;

import racingcar.common.Constants;
import java.util.Collections;

public class Car {
    private int numberOfMoves;

    public String move(MoveStrategy moveStrategy){
        this.numberOfMoves += moveStrategy.getMovingDistance();

        return String.join(Constants.JOIN_DELIMITER, Collections.nCopies(numberOfMoves, Constants.COPY_DELIMITER))
                .concat(Constants.NEW_LINE_DELIMITER);
    }
}
