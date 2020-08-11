package racingcar;

public class RepeatingCarMover implements CarMover {
    private static boolean flag = true;

    @Override
    public boolean movable() {
        if (flag) {
            flag = false;
            return flag;
        }
        flag = true;
        return flag;
    }
}
