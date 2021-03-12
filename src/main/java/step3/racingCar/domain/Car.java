/*
 * 자동차 경주의 자동차를 담당하는 클래스
 *
 * @author hj-woo
 * @version 1.0
 * */

package step3.racingCar.domain;

import java.util.Random;

public class Car {
    private int forwardNum;
    private Random random;
    private static final int INITNUM = 0;
    private static final int RANDOMBOUND = 10;

    public Car() {
        this.forwardNum = INITNUM;
        this.random = new Random();
    }

    public int getForwardNum() {
        return forwardNum;
    }

    /*
    * 자동차가 전진하거나 멈추는 함수이며 0~9 사이의 random값에서 4이상일 경우 전진한다.
    * 전진시에는 전진한 횟수를 +1한다.
    * @param null
    * @return 자동차의 전진 여부, boolean
    * */
    public boolean goForward(){
        if(random.nextInt(RANDOMBOUND) >= 4){
            forwardNum++;
            return true;
        }
        return false;
    }
}

