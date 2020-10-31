/**
 * 클래스 이름: Car
 * 버전 정보: 0.1
 * 날짜: 2020.10.30
 * 저작권 주의: 없음
 */

package racingcar;

public class Car {
    private int position;
    private MoveStrategy strategy;

    public Car(MoveStrategy strategy) {
        this.position = 1;
        this.strategy = strategy;
    }

    public void move() {
        if (this.strategy.checkMovable()) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
