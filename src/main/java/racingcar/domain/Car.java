package racingcar.domain;

import java.util.Collections;

public class Car {

    private int numberOfMoves;

    private final int THRESHOLD = 3;

    public String move(int randomNumber){
        if(randomNumber > THRESHOLD) this.numberOfMoves++;
        return String.join("", Collections.nCopies(numberOfMoves, "-"));
    }

}
