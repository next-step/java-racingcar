package racingcar;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class RacingCar implements Comparable<RacingCar>, Cloneable {

    public final static int RANDOM_BOUND = 10;
    public final static int MOVABLE_MIN = 4;
    public final static int MOVABLE_MAX = 9;

    private int position; // 최종 위치
    private String name;

    RacingCar() {}

    RacingCar(final String name) {
        this.name = name;
    }

    RacingCar(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    /**
     * 확인할 숫자에 따라 전진 할 수 있는지 아닌지를 반환한다.<br />
     *
     * @param num 전진 가능 여부 판단이 필요한 숫자
     * @return boolean
     */
    static boolean checkMovable(int num) {
        return num >= MOVABLE_MIN && num <= MOVABLE_MAX;
    }

    public int moveRandomly() {
        int randomNum = RacingUtil.generateRandomNum(RANDOM_BOUND);
        int move = checkMovable(randomNum) ? 1 : 0;

        this.position = this.position + move;

        return this.position;
    }

    public void printPosition() {
        System.out.println(this.name + " : " + StringUtils.repeat("-", this.position));
    }

    public void printName() {
        System.out.print(this.name);
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
}
