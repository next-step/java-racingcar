package step4.utils;

import step4.domain.Car;

public class Position {
    public static int maxPosition(Car car) {
        int maxPosition = 0;
        if(maxPosition < car.getPosition()) {
            maxPosition = car.getPosition();
        }
        return maxPosition;
    }
}
