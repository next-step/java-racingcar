package racingcar.service;

import java.util.ArrayList;
import java.util.List;

import static racingcar.RacingCarApplication.random;

public class Car {
    private static final int MOVING_CONDITION = 4;
    private static final int MAX_NUMBER = 10;
    private String name;
    private List<Integer> state;

    public Car(String name) {
        this.name = name;
    }

    public Car(List<Integer> state) {
        this.state = state;
    }

    public Car(String name, List<Integer> state) {
        this.name = name;
        this.state = state;
    }

    public List<Integer> getState() {
        return this.state;
    }

    public String getName() {
        return this.name;
    }


    public static List<Integer> race(int labs) {
        List<Integer> carState = new ArrayList<>();

        for (int lab = 0; lab < labs; lab++) {
            moveOrStop(carState, lab);
        }

        return carState;
    }

    private static void moveOrStop(List<Integer> carState, int lab) {
        int currentState = 0;
        if(lab != 0){
            currentState = carState.get(lab - 1);
        }

        if(checkMovingCondition(random.nextInt(MAX_NUMBER))){
            carState.add(move(currentState));
            return;
        }

        carState.add(stop(currentState));
    }

    public static int move(int currentState) {
        return currentState + 1;
    }

    public static int stop(int currentState) {
        return currentState;
    }

    public static boolean checkMovingCondition(int number) {
        if(number >= MOVING_CONDITION){
            return true;
        }

        return false;
    }
}
