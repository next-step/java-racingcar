package me.daeho.step3;

import me.daeho.step3.rule.ForwardRule;

public class Car {
    private final static int INITIAL_POSITION = 0;
    private final ForwardRule forwardRule;
    private int currentPosition;

    private Car(ForwardRule forwardRule, int currentPosition) {
        this.forwardRule = forwardRule;
        this.currentPosition = currentPosition;
    }

    public static Car ready(ForwardRule forwardRule) {
        return new Car(forwardRule, INITIAL_POSITION);
    }

    public int move() {
        if(forwardRule.isForward())
            return forward();

        return stop();
    }

    private int forward() {
        return ++currentPosition;
    }

    private int stop() {
        return currentPosition;
    }

}
