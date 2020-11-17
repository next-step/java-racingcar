package racingcar;

import java.util.Random;

public class RandomNumber {
    final private int baseLineNum = 4;

    public int makeNumber(){
        Random random = new Random();
        return random.nextInt(10);

    }
    public int isBigger(int randomNum){
        return randomNum >= baseLineNum?1:0;
    }
}
