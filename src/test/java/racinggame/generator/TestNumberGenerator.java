package racinggame.generator;

import racinggame.random.CapacityGenerator;

public class TestNumberGenerator implements CapacityGenerator {

    protected Integer value;

    public TestNumberGenerator(Integer value) {
        this.value = value;
    }

    public int generate() {
        return value;
    }
}
