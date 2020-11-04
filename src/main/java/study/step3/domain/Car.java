package study.step3.domain;

import java.util.List;

public interface Car {
    int NAME_MAX_LENGTH = 5;

    boolean isMoved();

    void move();

    String getName();

    default int getTotalTry() {
        return 0;
    }

    default int getDistanceDriven() {
        return 0;
    }

    default List<Boolean> takeDrivingRecordTake(int takes) {
        throw new RuntimeException("리펙토링이 끝나면 삭제될 메소드로 호출되면 안됨");
    }
}
