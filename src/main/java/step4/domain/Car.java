package step4.domain;

import step4.utils.RandomUtils;

public class Car {
    private static final int INITIAL_POSITION_NUM = 0;
    private static final int MAX_BOUND = 10;
    private static final int FORWARD_NUM = 4;

    private final Name name;
    private int position;

    private Car(final String name) {
        this(new Name(name), INITIAL_POSITION_NUM);
    }

    private Car(Name name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(final String name) {
        return new Car(name);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
}
