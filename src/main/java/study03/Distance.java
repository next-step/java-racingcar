package study03;

import java.util.Collections;

public class Distance {

    private int distance;

    public Distance(int initDistance) {
        this.distance = initDistance;
    }

    public void addDistance() {
        this.distance++;
    }

    public String totalMoved() {
        return String.join("", Collections.nCopies(this.distance, "-"));
    }

}
