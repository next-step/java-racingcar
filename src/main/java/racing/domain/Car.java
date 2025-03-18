package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {

    private int position = 1;

    public int moveForward() {
        return ++position;
    }

    public int getPosition() {
        return position;
    }
}
