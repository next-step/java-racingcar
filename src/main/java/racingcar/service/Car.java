package racingcar.service;

import java.util.*;

import static racingcar.RacingCarApplication.random;

public class Car {
    private final List<Integer> state;

    public Car(List<Integer> state) {
        this.state = state;
    }

    public List<Integer> getState() {
        return this.state;
    }

    public static List<Integer> race(int labs) {
        List<Integer> carState = new ArrayList<>();

        int currentState = 0;
        for (int lab = 0; lab < labs; lab++) {
            if (lab != 0) {
                currentState = carState.get(lab - 1);
            }
            carState.add(moveOrStop(currentState));
        }

        return carState;
    }

    private static int moveOrStop(int currentState) {
        if (moveIfOver4(random.nextInt(10))) {
            return move(currentState);
        }

        return stop(currentState);
    }

    public static int move(int currentState) {
        return currentState + 1;
    }

    public static int stop(int currentState) {
        return currentState;
    }

    public static boolean moveIfOver4(int number) {
        if (number < 4) {
            return false;
        }
        return true;
    }
}
