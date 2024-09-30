package step3;

public class TestEngine implements CarEngine {
    private final int power;

    public TestEngine(int power) {
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }

}
