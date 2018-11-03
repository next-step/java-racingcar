package racingcar;

public class RacingCar {

    private int position = 0;

    public int move(int random) {
        if(isMoving(random))
            return position+=1;

        return position;
    }

    public static boolean isMoving(int n) {
        return n >= 4;
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
