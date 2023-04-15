package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Car {

    private int position = 0;

    public void move(int instance) {
        if (judgeForth(instance)) position++;
    }

    public boolean judgeForth(int degree) {
        if (degree >= 4 && degree <= 9) {
            return true;
        }
        return false;
    }

    public int nowPosition() {
        return position;
    }

}
