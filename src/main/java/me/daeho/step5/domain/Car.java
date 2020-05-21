package me.daeho.step5.domain;

public class Car {
    private static final int INITIAL_POSITION = 0;

    private ForwardRule forwardRule;
    private int currentPosition;
    private String name;


    private Car(ForwardRule forwardRule, int currentPosition, String name) {
        this.forwardRule = forwardRule;
        this.currentPosition = currentPosition;
        this.name = name;
    }

    public static Car ready(ForwardRule forwardRule, String name) {
        return new Car(forwardRule, INITIAL_POSITION, name);
    }

    public int move() {
        if(forwardRule.isForward()) {
            return forward();
        }

        return stop();
    }

    private int forward() {
        return ++currentPosition;
    }

    private int stop() {
        return currentPosition;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
