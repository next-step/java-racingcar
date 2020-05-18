package study.step3;

public class MockRandomGenerator implements RandomGenerator{

    private int randomInt;

    public MockRandomGenerator(int randomInt) {
        this.randomInt = randomInt;
    }

    @Override
    public int getRandomInt() {
        return randomInt;
    }
}
