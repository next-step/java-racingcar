package racingcar.domain;

import racingcar.strategy.DoRace;

public class Car {
    //추상화 클래스? private 생성자 통한 인스턴스화 방지 가능? private Car(){}
    public Car(){}
    private int position;
    private DoRace doRace;

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setDoRace(DoRace doRace) {
        this.doRace = doRace;
    }

    /* Test Case 예시
       car.setDoRace(new DoOneForward());
       car.move();
       : OneForward()만큼 움직이는지 확인
     */
    public int move() {
        return doRace.move();
    }
}
