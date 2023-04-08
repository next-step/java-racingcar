package step3.domain;

import step3.util.RandomNumberUtils;

public class RacingCar {
    private static final int moveCondition = 4;
    private static final int defaultPosition = 0;
    private static final int defaultDistance = 1;

    private int position = defaultPosition;

    public int position() {
        return position;
    }

    public void steeringToForward() {
        if (RandomNumberUtils.generate() > moveCondition) {
            position += defaultDistance;
        }
    }
}

