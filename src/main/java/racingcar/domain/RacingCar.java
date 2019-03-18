package racingcar.domain;

import org.apache.commons.lang3.StringUtils;
import racingcar.util.RandomNumberMaker;

import java.util.Objects;

public class RacingCar implements Comparable<RacingCar>, Cloneable {

    private final static int RANDOM_BOUND = 10;
    private final static int MIN_MOVABLE = 4;
    private final static String DEFAULT_POSITION_LOOKS = "&nbsp;";

    private int position;
    final private String name;
    private String positionAsText;

    public RacingCar(final String name) {
        this.name = name;
    }

    public RacingCar(final String name, final int position) {
        this.name = name;
        this.position = position;
    }
    
    static boolean checkMovable(final int num) {
        return num >= MIN_MOVABLE && num < RANDOM_BOUND;
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
        return StringUtils.repeat(DEFAULT_POSITION_LOOKS, this.position);
    }

    public String getPositionAsText(final String positionLooks) {
        return StringUtils.repeat(positionLooks, this.position);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(final RacingCar car) {
        return Integer.compare(this.position, car.position);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RacingCar car = (RacingCar) o;

        return position == car.position &&
                Objects.equals(name, car.name);
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
