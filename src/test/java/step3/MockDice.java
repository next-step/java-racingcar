package step3;

public class MockDice implements Dice {

    private int testNum;

    public MockDice(int testNum) {
        this.testNum = testNum;
    }

    @Override
    public int getRandomNum() {
        return testNum;
    }
}
