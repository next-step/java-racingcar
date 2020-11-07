package racingcar.domain;

import racingcar.common.Constants;
import java.util.Collections;

public class Car {
    private String name;
    private int numberOfMoves;

    public Car(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfMoves(){
        return numberOfMoves;
    }

    public String move(MoveStrategy moveStrategy){
        this.numberOfMoves += moveStrategy.getMovingDistance();

        return name.concat(Constants.WHITE_SPACE_DELIMITER)
                .concat(Constants.COLON_DELIMITER)
                .concat(Constants.WHITE_SPACE_DELIMITER)
                .concat(String.join(Constants.BLANK_DELIMITER, Collections.nCopies(numberOfMoves, Constants.HYPHEN_DELIMITER)))
                .concat(Constants.NEW_LINE_DELIMITER);
    }
}
