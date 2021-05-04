package domain.core;

import static domain.core.GameOptions.DISTANCE_PRINT;

/**
 * 차 이동거리 원시값 포장
 */
public class Distance {
    private int distance;

    public Distance() {
        this.distance = 0;
    }

    public void increaseDistance() {
        distance++;
    }

    public String getDistancePrintMessage() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            sb.append(DISTANCE_PRINT);
        }
        return sb.toString();
    }

    public int getDistance() {
        return distance;
    }
}
