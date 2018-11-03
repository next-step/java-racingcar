package racingcar;

public class RacingCar {

    private int position = 0;
    private static final int MOVING_CONDITION = 4;

    public int move(int random) {
        if(isMoving(random))
            return position+=1;

        return position;
    }

    private boolean isMoving(int n) {
        return n >= MOVING_CONDITION;
    }

    @Override
    public String toString() {
        String str = "";

        for(int i = 0; i < position; i++) {
            str += "-";
        }
        return str;
    }
}
