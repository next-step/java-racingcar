package racingcar.service;

import java.util.*;

import static racingcar.RacingCarApplication.random;

public class Car {
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
        return moveIfOver4(random.nextInt(10)) ? move(currentState) : stop(currentState);
    }

    public static int move(int currentState) {
        return currentState + 1;
    }

    public static int stop(int currentState) {
        return currentState;
    }

    public static boolean moveIfOver4(int number) {
        return number >= 4 ? true : false;
    }
}
