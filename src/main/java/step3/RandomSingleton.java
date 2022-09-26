package step3;

import java.util.Random;

public enum RandomSingleton {
    INSTANCE;

    private final Random random;

    RandomSingleton() {
        this.random = new Random();
    }
    public Random getInstance() {
        return INSTANCE.random;
    }
}
