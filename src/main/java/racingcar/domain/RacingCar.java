package racingcar.domain;

import java.util.Random;

class RacingCar {
    private static final int THROTTLEBODY_OPEN_CONDITION = 4;
    private static final int THROTTLEBODY_OPEN_RANGE = 10;
    private static final String RACING_CAR_SYTLE = "-";
    private int state;

    public RacingCar() {
        this.state = 0;
    }

    protected boolean isThrottleBodyOpen(){
        final Random air = new Random();
        return THROTTLEBODY_OPEN_CONDITION <= air.nextInt(THROTTLEBODY_OPEN_RANGE);
    }

    protected int speed(){
        return isThrottleBodyOpen() ? 1 : 0;
    }

    protected int engin(int tryCount){
        int power = 0;
        for(int rpm = tryCount; 0 < rpm; --rpm){
            power += speed();
        }
        return power;
    }

    public void race(int tryCount){
        state =  engin(tryCount);
    }

    public String toDisplay(){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; state > i; ++i){
            sb.append(RACING_CAR_SYTLE);
        }
        return sb.toString();
    }
}
