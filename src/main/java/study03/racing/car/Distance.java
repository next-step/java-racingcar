package study03.racing.car;

import java.util.Collections;

public class Distance {

    private static final String MOVE_VIEW_CHARACTER = "-";

    private int distance;

    public Distance(int initDistance) {
        this.distance = initDistance;
    }

    public void addDistance() {
        this.distance++;
    }

    public String totalMoved() {
        return String.join("", Collections.nCopies(this.distance, MOVE_VIEW_CHARACTER));
    }

}
