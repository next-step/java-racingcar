package racing;

import org.apache.commons.lang3.StringUtils;

public class RacingCar {
    private String name;
    private int position;

    public RacingCar() {
    }

    public RacingCar(String name) {
        this(name, 0);
    }

    public RacingCar(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public int move(boolean isMove) {
        if (isMove)
            return position += 1;
        return position;
    }

    public boolean isMaxPosition(int maxPosition) {
        return maxPosition == position;
    }

    public int findMaxPosition(int checkPosition) {
        if (position > checkPosition)
            return position;
        return checkPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + Consts.FORMAT_COLON + StringUtils.repeat(Consts.PROGRESS_POSITION, position);
    }
}
