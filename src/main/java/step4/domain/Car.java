package step4.domain;

public class Car {
    private String player;
    private int distance;

    public Car(String player) {
        this.player = player;
    }

    public void tryMove(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            distance += 1;
        }
    }

    public String getPlayer() {
        return player;
    }

    public int getDistance() {
        return distance;
    }
}
