package step3.domain;

public class Car {

    private int moveDistance = 0;

    private final int MOVE_CONDITION = 4;

    public void move(int randomNum) {
        if(MOVE_CONDITION <= randomNum)
            moveDistance++;
    }

    public int getPosition() {
        return moveDistance;
    }
}
