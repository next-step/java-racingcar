package racing;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class Car {
    private static Random random = new Random();

    private Location lastMoveDistance;
    private Location location;
    private int moveCount;

    public Car() {
        this.location = Location.EMPTY;
        moveCount = 0;
    }

    public Location getLocation() {
        return location;
    }

    public Location getLastMoveDistance() {
        return lastMoveDistance;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move() {
        // 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
        int randomValue = random.nextInt(9);
        Location distance = new Location(
                randomValue >= 4 ? randomValue : 0
        );
        move(distance);
    }

    private void move(Location distance) {
        ++moveCount;

        this.location = location.add(distance);
        this.lastMoveDistance = distance;
    }
}
