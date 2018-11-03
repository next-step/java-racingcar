package racing;

import racing.rule.Forward;

import java.util.Objects;

public class Car {

    /**
     * 위치 기본값
     */
    private static final int DEFAULT_POSITION = 0;

    /**
     * 위치
     */
    private int position;

    /**
     * 위치 가져오기
     *
     * @return int
     */
    public int getPosition() {
        return position;
    }

    /**
     * 생성자
     */
    public Car() {
        initialize();
    }

    /**
     * 초기화
     */
    private void initialize() {
        position = DEFAULT_POSITION;
    }

    /**
     * 달리기
     */
    public void run() {
        if (Forward.isPossible()) {
            increasePosition();
        }
    }

    /**
     * 위치 증가
     */
    private void increasePosition() {
        position++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Car{");
        sb.append("position=").append(position);
        sb.append('}');
        return sb.toString();
    }

}
