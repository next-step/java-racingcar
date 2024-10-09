package racinggame.generator;

import racinggame.random.Radom;

public class TestNumberGenerator implements Radom {

    protected Integer value;

    public TestNumberGenerator(Integer value) {
        this.value = value;
    }

    public int generate() {
        return value;
    }
}
