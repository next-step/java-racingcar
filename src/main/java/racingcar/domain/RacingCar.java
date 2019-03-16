package racingcar.domain;

import org.apache.commons.lang3.StringUtils;
import racingcar.util.RandomNumberMaker;

import java.util.Objects;

public class RacingCar implements Comparable<RacingCar>, Cloneable {

    private final static int RANDOM_BOUND = 10;
    private final static int MIN_MOVABLE = 4;

    private int position;
    private String name;

    RacingCar() {}

    RacingCar(final String name) {
        this.name = name;
    }

    RacingCar(final String name, final int position) {
        this.name = name;
        this.position = position;
    }
    
    static boolean checkMovable(int num) {
        return num >= MIN_MOVABLE;
    }

    int moveRandomly() {
        int randomNum = RandomNumberMaker.generate(RANDOM_BOUND);
        int move = checkMovable(randomNum) ? 1 : 0;

        this.position = this.position + move;

        return this.position;
    }

    int getMaxPosition(final int maxPosition) {
        if (this.position > maxPosition) {
            return this.position;
        }

        return maxPosition;
    }

    boolean hasMaxPosition(final int maxPosition) {
        return this.position == maxPosition;
    }

    public String getPositionAsText() {
        return this.name + " : " + StringUtils.repeat("-", this.position);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(RacingCar racingCar) {
        return Integer.compare(this.position, racingCar.position);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RacingCar racingCar = (RacingCar) o;

        return position == racingCar.position &&
                Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }

    @Override
    public String toString() {
        return "RacingCar{" +
                "position=" + position +
                ", name='" + name + '\'' +
                '}';
    }
}
