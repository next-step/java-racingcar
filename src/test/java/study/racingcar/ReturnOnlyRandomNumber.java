package study.racingcar;

import java.util.Random;

public class ReturnOnlyRandomNumber extends Random {

    private int boundNum;

    public ReturnOnlyRandomNumber(int boundNum){
        this.boundNum = boundNum;
    }

    @Override
    public int nextInt(int bound) {
        return boundNum;
    }
}
