package racingcar.domain;

public class RepeatingCarMover implements CarMover {
    private static boolean flag = true;

    @Override
    public boolean movable() {
        flag = !flag;
        return flag;
    }
}
