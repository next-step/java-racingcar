package racing.core;

import racing.RandomUtil;

public class Mover {

    private static final int STEP_COUNT = 1;
    private static final int DEFAULT_FORWARD_DECIDER = 4;

    public Mover() {}

    public void move(Car car){
        int randomNum = RandomUtil.getRandomNumUnder10();
        if(isForward(randomNum)){
            car.stepAhead(STEP_COUNT);
        }
    }

    private boolean isForward(int num){
        return num >= DEFAULT_FORWARD_DECIDER;
    }

}
