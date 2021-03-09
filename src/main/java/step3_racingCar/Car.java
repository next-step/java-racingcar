package step3_racingCar;
/*
* 자동차 경주의 자동차를 담당하는 클래스
*
*
* @author hj-woo
* @version 1.0
* */

import java.util.Random;

public class Car {
    private int forwardNum;
    private Random random;
    private static final int INITNUM = 0;
    private static final int RANDOMBOUND = 10;

    public Car() {
        this.forwardNum = INITNUM;
    }

    public int getForwardNum() {
        return forwardNum;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public boolean goForward(){
        if(random.nextInt(RANDOMBOUND) >= 4){
            forwardNum++;
            return true;
        }
        return false;
    }
}

