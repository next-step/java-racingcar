package step3_racingCar;
/*
* 자동차 경주의 자동차를 담당하는 클래스
*
*
* @author hj-woo
* @version 1.0
* */

public class Car {
    private int forwardNum;
    private static final int INITNUM = 0;

    public Car() {
        this.forwardNum = INITNUM;
    }

    public int getForwardNum() {
        return forwardNum;
    }
}

