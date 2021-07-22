package racingcar;

import racingcar.common.ErrorMessage;
import racingcar.common.Properties;

public class Distance {

    private final int minAddInput = 0;

    private int distance;

    public Distance() {
        this.distance = Properties.INITIAL_DISTANCE;
    }

    public void add(int addDistance) {
        if (!addValidation(addDistance)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_ADD_DISTANCE);
        }
        distance += addDistance;
    }

    public int get() {
        return distance;
    }

    private boolean addValidation(int addDistance) {
        if (addDistance >= minAddInput) {
            return true;
        }

        return false;
    }
}
