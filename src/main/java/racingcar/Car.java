package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private int moveTotalCnt;

    public void run(boolean isMove) {
        if (isMove) {
            moveTotalCnt++;
        }
    }
    public int getMoveTotalCnt() {
        return moveTotalCnt;
    }
}
