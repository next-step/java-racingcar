package study.step3.domain;

import java.util.List;

public interface Car {
    int NAME_MAX_LENGTH = 5;

    boolean isMoved();

    void move();

    String getName();

    int getTotalTry();

    int getDistanceDriven();

    List<Boolean> takeDrivingRecordTake(int takes);
}
