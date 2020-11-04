package racingcar.domain;

import racingcar.common.Constants;

import java.util.Collections;

public class Car {
    private int numberOfMoves;

    private final int THRESHOLD = 3;

    public String move(int randomNumber){
        if(randomNumber > THRESHOLD) this.numberOfMoves++;

        return String.join(Constants.JOIN_DELIMITER, Collections.nCopies(numberOfMoves, Constants.COPY_DELIMITER))
                .concat(Constants.NEW_LINE_DELIMITER);
    }
}
