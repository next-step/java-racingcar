package racingcar;

public class Car {

    public static final int MOVE_LIMIT = 4;
    private int distance = 0;

    public void move(int random) {
        if(isMovePossible(random)){
            this.distance +=1;
        }
    }

    private boolean isMovePossible(int random) {
        return random >= MOVE_LIMIT;
    }

    public int getDistance() {
        return distance;
    }
}
