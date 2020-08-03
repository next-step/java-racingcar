package racingcar.domain;

import racingcar.strategy.RacingStrategy;

public abstract class Car {
    //추상화 클래스이면 private 생성자 통한 인스턴스화 방지 가능?
    //   private Car(){}
    private int seq;
    private int position;
    private RacingStrategy racingStrategy;

    //*********************************Getter/Setter 대신 구현 방법 고민 //
    public int getSeq() {
        return seq;
    }

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setRacingStrategy(RacingStrategy racingStrategy) {
        this.racingStrategy = racingStrategy;
    }

    public int move() {
        racingStrategy.move();
    }
}
