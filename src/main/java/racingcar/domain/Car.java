package racingcar.domain;

import racingcar.common.Constants;
import java.util.Collections;

public class Car {
    private String name;
    private int numberOfMoves;

    public Car(String name){
        this.name = name;
    }

    public int getNumberOfMoves(){
        return numberOfMoves;
    }

    public String move(MoveStrategy moveStrategy){
        this.numberOfMoves += moveStrategy.getMovingDistance();

        return name.concat(" : ")
                .concat(String.join(Constants.JOIN_DELIMITER, Collections.nCopies(numberOfMoves, Constants.COPY_DELIMITER)))
                .concat(Constants.NEW_LINE_DELIMITER);
    }

    public String getName() {
        return name;
    }
}
