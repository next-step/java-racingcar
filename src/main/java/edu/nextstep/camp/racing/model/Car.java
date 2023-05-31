package edu.nextstep.camp.racing.model;

import java.text.StringCharacterIterator;
import java.util.Arrays;

public class Car {

    private final int[] positions;

    private static final int IS_MOVE = 1;
    private static final int IS_NOT_MOVE = 0;

    public Car(int movingCnt) {
        positions = new int[movingCnt];

        Arrays.fill(positions, IS_NOT_MOVE);
    }

    public void move(boolean isMove, int racingIndex) {
        if (isMove){

            positions[racingIndex] = IS_MOVE;
        }
    }

    public int distance(){
        return distance(positions.length-1);
    }

    public int distance(int positionIndex){
        int distance = 0;

        for (int i = 0; i <= positionIndex; i++) {
            distance += positions[i];
        }

        return distance;
    }
}
