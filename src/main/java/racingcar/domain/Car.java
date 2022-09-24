package racingcar.domain;

import racingcar.exception.ExceptionMessageUtil;

public class Car {

    private int distance;
    private RandomNumber randomNumber;

    private static final String GRAPH_BAR = "-";
    private static final int RUNNABLE_BOUND = 4;
    private static final int MAX_VALUE = 9;
    private static final int MIN_VALUE = 0;

    public Car(RandomNumber randomNumber) {
        this.distance = 0;
        this.randomNumber = randomNumber;

        if (MIN_VALUE > randomNumber.min() || MAX_VALUE < randomNumber.max()) {
            throw new IllegalArgumentException(ExceptionMessageUtil.outOfBoundedException(MIN_VALUE, MAX_VALUE));
        }
    }

    public Car() {
        this.distance = 0;
        this.randomNumber = new RandomNumber(MIN_VALUE, MIN_VALUE);
    }

    public void run() {
        if (isRunnable()) {
            this.distance += 1;
        }
    }

    public String showDistanceGraph() {
        StringBuilder graph = new StringBuilder();
        for (int i = 0; i < this.distance; i++) {
            graph.append(GRAPH_BAR);
        }
        return graph.toString();
    }

    public int distance() {
        return this.distance;
    }

    private boolean isRunnable() {
        return RUNNABLE_BOUND < randomNumber.nextInt();
    }
}
