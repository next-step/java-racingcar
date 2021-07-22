package racing;

import java.util.Random;

public class Car {
    private static Random random;

    private Location location;
    private int moveCount;

    public Location getLocation() {
        return location;
    }

    public Car() {
        this.location = new Location();
        moveCount = 0;
    }

    public void move() {
        // 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
        int randomValue = random.nextInt(9);
        move(randomValue >= 4 ? randomValue : 0);
    }

    // private 메소드 이지만 테스트를 위해 public 변경
    public void move(int distance) {
        if (distance > 0) {
            this.location = new Location(
                    this.getLocation().getValue() + distance
            );
        }
        ++moveCount;
    }
}
