/*
 * 각 자동차 객체로, 이동 거리를 관리하는 클래스
 * */
package step3;

public class Car {

    public int position;

    public Car(int position) {
        this.position = position;
    }

    /**
     * 자동차의 위치를 변경하는 메소드
     */
    public void move() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }
}
