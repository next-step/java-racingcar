package racingCar;

import java.util.Random;

public class Car {

    private static final int MINIMUM_MOVE_THRESHOLD = 4;
    private static final int RANDOM_LIMIT = 10;
    private static final String STATE_PRINT_FORMAT = "-";

    private final int state;

    public Car(int state){
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public boolean isMoveable(){
        return state >= MINIMUM_MOVE_THRESHOLD;
    }

    public String printStatus() {
        StringBuffer sb = new StringBuffer();
        sb.append(STATE_PRINT_FORMAT);

        for(int i = 0; i < state; i++){
            sb.append(STATE_PRINT_FORMAT);
        }
        return sb.toString();
    }

    public void run() {
        System.out.println(printStatus());
    }
}
