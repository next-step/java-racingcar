package racing.core;

public class Car {

    public static final int CONDITION = 4;

    public boolean move(int random) {
        return random >= CONDITION;
    }
}
